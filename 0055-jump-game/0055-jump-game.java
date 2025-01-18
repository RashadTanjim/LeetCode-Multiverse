class Solution {
    public boolean canJump(int[] nums) {

        int steps = 0;

        for (int i = 0; i < nums.length; i++) {

            if (steps < i) {
                return false;
            }

            steps = Math.max(steps, i + nums[i]);

            if (steps >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}