class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            int[] newDp = new int[n];

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    newDp[j] = grid[i][j];
                } else {
                    int up = i > 0 ? dp[j] : Integer.MAX_VALUE;
                    int left = j > 0 ? newDp[j - 1] : Integer.MAX_VALUE;
                    newDp[j] = grid[i][j] + Math.min(up, left);
                }
            }
            dp = newDp;
        }

        return dp[n - 1];
    }
}