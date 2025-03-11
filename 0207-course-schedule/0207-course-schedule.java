class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build graph and in-degree array
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph.putIfAbsent(prereq, new ArrayList<>());
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Find courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        // Process courses in BFS order
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            if (graph.containsKey(curr)) {

                for (int neighbor : graph.get(curr)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0)
                        queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }
}