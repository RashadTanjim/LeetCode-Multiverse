class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int[] ans = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long required = (success + spells[i] - 1) / spells[i]; // ceil division
            int idx = lowerBound(potions, required);
            ans[i] = m - idx;
        }
        return ans;
    }

    private int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length;

        while (l < r) {        // binary search
            int mid = l + (r - l) / 2;
            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}