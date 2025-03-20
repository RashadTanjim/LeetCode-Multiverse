class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        backtrack(0, n, 0, 0, 0);
        return count;
    }

    private void backtrack(int row, int n, int cols, int diagonals, int antiDiagonals) {
        if (row == n) {
            count++;
            return;
        }

        int availablePositions = ((1 << n) - 1) & ~(cols | diagonals | antiDiagonals);

        while (availablePositions != 0) {
            int position = availablePositions & -availablePositions; // Get rightmost available position
            availablePositions -= position; // Remove this position

            backtrack(row + 1, n, cols | position, (diagonals | position) << 1, (antiDiagonals | position) >> 1);
        }
    }
}