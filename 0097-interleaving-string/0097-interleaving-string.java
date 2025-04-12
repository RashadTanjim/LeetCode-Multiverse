class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length())
            return false;
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0, 0, s1, s2, s3, memo);
    }

    private boolean dfs(int i, int j, String s1, String s2, String s3, Boolean[][] memo) {
        if (i == s1.length() && j == s2.length())
            return true;
        if (memo[i][j] != null)
            return memo[i][j];

        int k = i + j;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (dfs(i + 1, j, s1, s2, s3, memo)) {
                return memo[i][j] = true;
            }
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (dfs(i, j + 1, s1, s2, s3, memo)) {
                return memo[i][j] = true;
            }
        }

        return memo[i][j] = false;
    }
}