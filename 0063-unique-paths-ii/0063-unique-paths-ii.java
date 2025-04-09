class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];

        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int[] row : obstacleGrid) {
            for (int col = 0; col < obstacleGrid[0].length; col++) {

                if (row[col] == 1)
                    dp[col] = 0;
                else if (col > 0)
                    dp[col] += dp[col - 1];
            }
        }

        return dp[obstacleGrid[0].length - 1];
    }
}