class Solution {
    public int hIndex(int[] citations) { // Time: O(n) || Space: O(n + 1) -> 1 n for using counting array

        int n = citations.length;
        int[] count = new int[n + 1];
        int max = 0;

        for (int citation : citations) {
            ++count[Math.min(citation, n)];
        }

        for (int i = n; i >= 0; --i) { // i is the candidate's h-index
            max += count[i];
            if (max >= i)
                return i;
        }

        return 0;
    }
}
