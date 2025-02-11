class Solution {
    public int[] twoSum(int[] nums, int target) { // Time: O(n), Space: O(1)

        for (int i = 1; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {

                if (nums[j] + nums[j - i] == target) {
                    return new int[] { j - i, j };
                }
            }
        }

        return new int[] {};
    }
}