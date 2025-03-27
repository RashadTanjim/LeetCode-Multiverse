class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (nums[mid] == target) {

                int left = mid;
                while (left - 1 >= low && nums[left - 1] == target) {
                    left--;
                }
                result[0] = left;

                int right = mid;
                while (right + 1 <= high && nums[right + 1] == target) {
                    right++;
                }
                result[1] = right;

                break;
            }

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}