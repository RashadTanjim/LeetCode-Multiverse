class Solution {
    public int jump(int[] nums) {
        int farthest = 0; // farthest index
        int end = 0; // farthest end to reach
        int jump = 0; // number of jumps taken to reach the goal
        int n = nums.length; // last index

        for (int i = 0; i < n - 1; i++) {

            if (farthest < i + nums[i]) {
                farthest = i + nums[i];
            }

            if (i == end) {
                jump++;
                end = farthest;
            }
        }
        return jump;
    }
}