class Solution {
    public int snakesAndLadders(int[][] board) { // BFS
        int N = board.length;
        int[] flattenBoard = new int[N * N + 1]; // 1-based indexing
        boolean leftToRight = true;
        int index = 1;

        // Step 1: Flatten 2D board into 1D array
        for (int row = N - 1; row >= 0; row--) {

            if (leftToRight) {
                for (int col = 0; col < N; col++) {
                    flattenBoard[index++] = board[row][col];
                }
            } else {
                for (int col = N - 1; col >= 0; col--) {
                    flattenBoard[index++] = board[row][col];
                }
            }

            leftToRight = !leftToRight;
        }

        // Step 2: BFS to find the shortest path
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N * N + 1];
        
        queue.offer(new int[] { 1, 0 }); // {current square, moves}
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0], moves = current[1];

            // If we reached the last square, return moves
            if (pos == N * N)
                return moves;

            // Roll dice (1 to 6)
            for (int i = 1; i <= 6; i++) {
                int nextPos = pos + i;

                if (nextPos > N * N)
                    break; // Out of bounds

                if (flattenBoard[nextPos] != -1) {
                    nextPos = flattenBoard[nextPos]; // Ladder or snake
                }

                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.offer(new int[] { nextPos, moves + 1 });
                }
            }
        }

        return -1; // No way to reach the last square
    }
}