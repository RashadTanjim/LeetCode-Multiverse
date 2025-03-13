class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[bank.length];

        queue.offer(startGene);
        int mutations = 0;

        // Process the queue using BFS
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();

                // If we've reached the end gene, return the number of mutations
                if (currentGene.equals(endGene)) {
                    return mutations;
                }

                // Try all genes in the bank to see if they differ by exactly one character
                for (int j = 0; j < bank.length; j++) {

                    if (visited[j])
                        continue;

                    if (isOneMutationApart(bank[j], currentGene)) {
                        visited[j] = true; // Mark as visited
                        queue.offer(bank[j]);
                    }
                }
            }
            mutations++;
        }

        return -1;
    }

    // Helper function to check if two genes differ by exactly one character
    private boolean isOneMutationApart(String gene1, String gene2) {
        int differences = 0;

        for (int i = 0; i < gene1.length(); i++) {

            if (gene1.charAt(i) != gene2.charAt(i)) {
                differences++;
                if (differences > 1)
                    return false;
            }
        }
        return differences == 1;
    }
}