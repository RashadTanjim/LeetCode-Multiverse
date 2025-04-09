class Solution {
    public int uniquePaths(int m, int n) { // Combinatorics
        long paths = 1;

        for (int i = 1; i <= m - 1; i++) { // The total number of unique ways = C(m+n-2, m-1)
            paths = paths * (n - 1 + i) / i;
        }

        return (int) paths;
    }
}