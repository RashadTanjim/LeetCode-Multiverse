class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int rows = board.length, cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Capture all border 'O's into the queue
        for (int i = 0; i < rows; i++) {

            if (board[i][0] == 'O')
                queue.offer(new int[] { i, 0 });

            if (board[i][cols - 1] == 'O')
                queue.offer(new int[] { i, cols - 1 });
        }

        for (int j = 0; j < cols; j++) {

            if (board[0][j] == 'O')
                queue.offer(new int[] { 0, j });

            if (board[rows - 1][j] == 'O')
                queue.offer(new int[] { rows - 1, j });
        }

        // Step 2: BFS to mark connected 'O's as safe ('#')
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O')
                continue;

            board[r][c] = '#';

            for (int[] dir : directions) {
                queue.offer(new int[] { r + dir[0], c + dir[1] });
            }
        }

        // Step 3: Flip surrounded 'O' to 'X' and restore '#' to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X'; // Flip surrounded

                if (board[i][j] == '#')
                    board[i][j] = 'O'; // Restore safe regions
            }
        }
    }

}