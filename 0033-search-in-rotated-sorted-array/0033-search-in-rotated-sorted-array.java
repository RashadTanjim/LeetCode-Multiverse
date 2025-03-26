class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1; // Prevents overflow

            if (nums[mid] == target) {
                return mid; // base case
            }

            // Determine the sorted half
            if (nums[low] <= nums[mid]) { // Left half is sorted

                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Search left
                } else {
                    low = mid + 1; // Search right
                }

            } else { // Right half is sorted

                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }
        }

        return -1;
    }
}