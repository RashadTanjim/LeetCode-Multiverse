class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int remainder = sum % k;

        if (remainder == 0)
            return 0;

        return remainder;
    }
}