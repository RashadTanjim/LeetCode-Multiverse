import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0)
            return result;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        int[] dr = { 0, 1, 0, -1 }; // Right, Down, Left, Up
        int[] dc = { 1, 0, -1, 0 };
        int row = 0, col = 0, dir = 0;

        for (int i = 0; i < m * n; i++) {
            result.add(matrix[row][col]);
            visited[row][col] = true;

            int newRow = row + dr[dir], newCol = col + dc[dir];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                row = newRow;
                col = newCol;
            } else {
                dir = (dir + 1) % 4; // Change direction
                row += dr[dir];
                col += dc[dir];
            }
        }

        return result;
    }
}
