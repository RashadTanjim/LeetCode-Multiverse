class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        Integer[][] memo = new Integer[m + 1][n + 1];
        
        return dp(word1, word2, m, n, memo);
    }

    private int dp(String word1, String word2, int i, int j, Integer[][] memo) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;

        if (memo[i][j] != null)
            return memo[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            memo[i][j] = dp(word1, word2, i - 1, j - 1, memo);

        } else {
            int insert = dp(word1, word2, i, j - 1, memo);
            int delete = dp(word1, word2, i - 1, j, memo);
            int replace = dp(word1, word2, i - 1, j - 1, memo);

            memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }

        return memo[i][j];
    }
}