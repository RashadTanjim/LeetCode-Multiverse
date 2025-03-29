class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.capital));
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new Project(capital[i], profits[i]));
        }

        // Perform up to k projects
        for (int i = 0; i < k; i++) {

            // Add all projects we can afford to maxProfitHeap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll().profit);
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            w += maxProfitHeap.poll();
        }

        return w;
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