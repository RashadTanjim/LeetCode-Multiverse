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

// Example go throuth -->
// Input: nums = [1, 2, 3, 4]
//
// First Pass (Right-to-Left):
// Initialize: answer = [0, 0, 0, 1].
// Iteration:
// i = 2: answer[2] = nums[3] * answer[3] = 4 * 1 = 4.
// i = 1: answer[1] = nums[2] * answer[2] = 3 * 4 = 12.
// i = 0: answer[0] = nums[1] * answer[1] = 2 * 12 = 24.
// After first pass: answer = [24, 12, 4, 1].

// Second Pass (Left-to-Right):
// Initialize: multiply = nums[0] = 1.
// Iteration:
// i = 1: answer[1] = multiply * answer[1] = 1 * 12 = 12. Update multiply =
// multiply * nums[1] = 1 * 2 = 2.
// i = 2: answer[2] = multiply * answer[2] = 2 * 4 = 8. Update multiply =
// multiply * nums[2] = 2 * 3 = 6.
// i = 3: answer[3] = multiply * answer[3] = 6 * 1 = 6. Update multiply =
// multiply * nums[3] = 6 * 4 = 24.
// After second pass: answer = [24, 12, 8, 6].

// Output:

// [24, 12, 8, 6]