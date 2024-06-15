class Solution {
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int n = profits.length;
        Project[] projects = new Project[n];

        // Create project objects and sort by capital needed
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        
        Arrays.sort(projects, Comparator.comparingInt(p -> p.capital));

        MaxHeap maxHeap = new MaxHeap();
        int projectIndex = 0;

        for (int i = 0; i < k; i++) {
            
            // Add all projects that can be started with current capital
            while (projectIndex < n && projects[projectIndex].capital <= w) {
                maxHeap.push(projects[projectIndex].profit);
                projectIndex++;
            }

            // If no projects can be started, break early
            if (maxHeap.isEmpty()) {
                break;
            }

            // Choose the most profitable project
            w += maxHeap.pop();
        }

        return w;
    }
    
        
    // Max heap implementation using PriorityQueue
    private static class MaxHeap {
        
        private PriorityQueue<Integer> heap;

        public MaxHeap() {
            heap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void push(int val) {
            heap.add(val);
        }

        public int pop() {
            return heap.poll();
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }
    }
    
    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

}