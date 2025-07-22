class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<String> directedEdges = new HashSet<>();

        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, x -> new ArrayList<>()).add(from);
            directedEdges.add(from + "->" + to);
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, directedEdges, visited);
    }

    private int dfs(int curr, Map<Integer, List<Integer>> graph, Set<String> directedEdges, boolean[] visited) {
        visited[curr] = true;
        int changes = 0;

        for (int neighbor : graph.getOrDefault(curr, new ArrayList<>())) {

            if (!visited[neighbor]) {
                if (directedEdges.contains(curr + "->" + neighbor)) {
                    changes++;
                }
                changes += dfs(neighbor, graph, directedEdges, visited);
            }
        }

        return changes;
    }
}