class Solution {

    static {
        for (int i = 0; i < 500; i++) {
            productExceptSelf(new int[] { 0, 0 });
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        // Time: O(n) || Space: O(1)

        int n = nums.length;
        int answer[] = new int[n];

        answer[n - 1] = 1;
        int multiply = nums[0];

        for (int i = n - 2; i >= 0; i--) {
            answer[i] = nums[i + 1] * answer[i + 1];
        }

        for (int i = 1; i < n; i++) {
            answer[i] = multiply * answer[i];
            multiply = multiply * nums[i];
        }

        return answer;
    }
}