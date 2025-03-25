class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxKadane = kadane(nums);

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i];
        }

        int minKadane = kadane(nums);
        int maxCircular = totalSum + minKadane;

        if (maxCircular == 0)
            return maxKadane;

        return Math.max(maxKadane, maxCircular);
    }

    private int kadane(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        for (int num : nums) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}