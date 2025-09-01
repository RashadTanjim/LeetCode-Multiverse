class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Collections.singletonList(0);

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new HashSet<>());
            
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remaining = n;
        while (remaining > 2) {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}