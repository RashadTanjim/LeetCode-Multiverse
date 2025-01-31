class Solution {
    public int minSubArrayLen(int target, int[] nums) { // sliding window approach - Time: O(n) || Space: O(1)

        int left = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}