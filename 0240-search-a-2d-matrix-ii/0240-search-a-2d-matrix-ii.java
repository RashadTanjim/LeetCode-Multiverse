class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int value = matrix[row][col];
            
            if (value == target) {
                return true;
            } else if (value > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}