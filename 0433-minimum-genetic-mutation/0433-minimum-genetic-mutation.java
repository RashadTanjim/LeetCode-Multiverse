class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene))
            return -1;

        char[] genes = { 'A', 'C', 'G', 'T' };
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>();

        beginSet.add(startGene);
        endSet.add(endGene);
        int mutations = 0;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();
            for (String gene : beginSet) {
                char[] geneArray = gene.toCharArray();

                for (int i = 0; i < geneArray.length; i++) {
                    char originalChar = geneArray[i];

                    for (char g : genes) {
                        if (g == originalChar)
                            continue;
                        geneArray[i] = g;
                        String newGene = new String(geneArray);

                        if (endSet.contains(newGene))
                            return mutations + 1;

                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                            nextLevel.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    geneArray[i] = originalChar;
                }
            }
            beginSet = nextLevel;
            mutations++;
        }

        return -1;
    }
}