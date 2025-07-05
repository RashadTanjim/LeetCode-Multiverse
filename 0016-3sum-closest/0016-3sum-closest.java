class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closesSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int curSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(curSum - target) < Math.abs(closesSum - target)) {
                    closesSum = curSum;
                }

                if (curSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closesSum;
    }
}