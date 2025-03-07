class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols]; // Separate visited array
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++; // New island found
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int rows = grid.length, cols = grid[0].length;

        // Boundary and water check
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true; // Mark as visited

        // All 8 directions
        int[][] directions = {
                { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }// Left, Right, Up, Down
        };

        for (int[] dir : directions) {
            dfs(grid, visited, i + dir[0], j + dir[1]);
        }
    }
}