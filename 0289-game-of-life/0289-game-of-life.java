class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // Directions for 8 neighbors
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Step 1: Encode changes in-place
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int d = 0; d < 8; d++) {
                    int ni = i + dx[d], nj = j + dy[d];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && Math.abs(board[ni][nj]) == 1) {
                        liveNeighbors++;
                    }
                }

                // Apply rules using encoded values
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1; // Alive â Dead
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2; // Dead â Alive
                }
            }
        }

        // Step 2: Decode the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == -1)
                    board[i][j] = 0;
                if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
}