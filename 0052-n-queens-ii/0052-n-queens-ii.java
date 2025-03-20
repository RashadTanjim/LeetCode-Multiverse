class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();
        Set<Integer> antiDiagonals = new HashSet<>();

        backtrack(0, n, cols, diagonals, antiDiagonals);
        return count;
    }

    private void backtrack(int row, int n, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            if (cols.contains(col) || diagonals.contains(row - col) || antiDiagonals.contains(row + col)) {
                continue;
            }

            cols.add(col);
            diagonals.add(row - col);
            antiDiagonals.add(row + col);

            backtrack(row + 1, n, cols, diagonals, antiDiagonals);

            cols.remove(col);
            diagonals.remove(row - col);
            antiDiagonals.remove(row + col);
        }
    }
}