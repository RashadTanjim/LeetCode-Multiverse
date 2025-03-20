class Solution {
    private List<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, n, 0, 0, 0, board);
        return solutions;
    }

    private void backtrack(int row, int n, int cols, int diagonals, int antiDiagonals, char[][] board) {
        if (row == n) {
            solutions.add(constructBoard(board));
            return;
        }

        int availablePositions = ((1 << n) - 1) & ~(cols | diagonals | antiDiagonals);

        while (availablePositions != 0) {
            int position = availablePositions & -availablePositions; // Get rightmost available position
            availablePositions -= position; // Remove this position

            int col = Integer.bitCount(position - 1); // Convert bitmask to column index

            board[row][col] = 'Q'; // Place queen
            backtrack(row + 1,
                    n,
                    cols | position,
                    (diagonals | position) << 1,
                    (antiDiagonals | position) >> 1,
                    board);
            board[row][col] = '.'; // Backtrack
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();

        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}