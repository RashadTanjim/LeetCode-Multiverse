class Solution {
    public String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) return "";

        int numPositions = votes[0].length();
        Map<Character, int[]> countMap = new HashMap<>();

        // Initialize map
        for (char c : votes[0].toCharArray()) {
            countMap.put(c, new int[numPositions]);
        }

        // Count votes
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char team = vote.charAt(i);
                countMap.get(team)[i]++;
            }
        }

        // Sort with custom comparator
        List<Character> teams = new ArrayList<>(countMap.keySet());
        teams.sort((a, b) -> {
            for (int i = 0; i < numPositions; i++) {
                if (countMap.get(a)[i] != countMap.get(b)[i]) {
                    return countMap.get(b)[i] - countMap.get(a)[i];
                }
            }
            return Character.compare(a, b);
        });

        // Build result
        StringBuilder sb = new StringBuilder();
        for (char c : teams) sb.append(c);
        return sb.toString();
    }
}
