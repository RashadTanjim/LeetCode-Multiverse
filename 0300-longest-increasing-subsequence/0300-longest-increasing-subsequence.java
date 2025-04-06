class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n]; // Max possible size is n
        int size = 0;

        for (int num : nums) {
            int idx = binarySearch(tails, 0, size - 1, num);

            if (idx == size) {
                tails[size++] = num; // Extend the sequence
            } else {
                tails[idx] = num; // Replace to maintain minimal tails
            }
        }

        return size;
    }

    // Binary search: Find first index where tails[i] >= target
    private int binarySearch(int[] tails, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (tails[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left; // Insertion point
    }
}