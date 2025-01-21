class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Time: O(n) || Space: O(1)

        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int pos = 1;

        for (int i = 0; i < n; i++) {
            ans[i] *= pos;
            pos *= nums[i];
        }

        pos = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= pos;
            pos *= nums[i];
        }

        return ans;
    }
}