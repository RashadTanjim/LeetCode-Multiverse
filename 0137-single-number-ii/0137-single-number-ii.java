class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos; // Add new number or remove it if seen twice
            twos = (twos ^ num) & ~ones; // Track numbers that appear twice
        }

        return ones;
    }
}