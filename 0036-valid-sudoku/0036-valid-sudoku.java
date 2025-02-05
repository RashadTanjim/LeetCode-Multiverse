public class Solution {

    public boolean isValidSudoku(char[][] board) {

        // Check rows and columns
        for (int i = 0; i < 9; i++) {
            if (!isValidBlock(board, i, 0, i, 8) || !isValidBlock(board, 0, i, 8, i)) {
                return false;
            }
        }

        // Check each 3x3 sub-box
        for (int row = 0; row < 9; row += 3) {

            for (int col = 0; col < 9; col += 3) {
                if (!isValidBlock(board, row, col, row + 2, col + 2)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidBlock(char[][] board, int rowStart, int colStart, int rowEnd, int colEnd) {
        boolean[] seen = new boolean[9]; // To store digits 1-9

        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                char num = board[i][j];

                if (num != '.') {
                    int index = num - '1';

                    if (seen[index])
                        return false;

                    seen[index] = true;
                }
            }
        }

        return true;
    }
}
