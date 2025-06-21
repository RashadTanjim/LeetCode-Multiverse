class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        int count = 0;

        for (int[] row : grid) {
            String key = encode(row);
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        for (int c = 0; c < n; c++) {
            int[] col = new int[n];
            
            for (int r = 0; r < n; r++) {
                col[r] = grid[r][c];
            }

            String colKey = encode(col);
            count += rowMap.getOrDefault(colKey, 0);
        }

        return count;
    }

    private static String encode(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append("#");
        }
        return sb.toString();
    }
}