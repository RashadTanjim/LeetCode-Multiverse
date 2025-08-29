class Solution {
    private int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color)
            return image;

        dfs(image, sr, sc, oldColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length)
            return;
        if (image[r][c] != oldColor)
            return;

        image[r][c] = newColor;
        for (int[] dir : directions) {
            dfs(image, r + dir[0], c + dir[1], oldColor, newColor);
        }
    }
}