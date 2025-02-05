public class Solution {

    public static boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9]; // Track numbers in rows
        int[] cols = new int[9]; // Track numbers in columns
        int[] boxes = new int[9]; // Track numbers in 3x3 boxes

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num != '.') {
                    int val = num - '1'; // Convert '1'-'9' to 0-8
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    int mask = 1 << val; // Bit mask for current number
                    if ((rows[i] & mask) != 0 || (cols[j] & mask) != 0 || (boxes[boxIndex] & mask) != 0) {
                        return false; // Duplicate detected
                    }

                    // Mark the number in row, column, and box
                    rows[i] |= mask;
                    cols[j] |= mask;
                    boxes[boxIndex] |= mask;
                }
            }
        }

        return true;
    }
}
