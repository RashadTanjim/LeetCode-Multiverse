class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n < 3)
            return n;

        // Find the Most Significant Bit
        int count = 0;
        int temp = n;
        while (temp > 0) {
            temp >>= 1;
            count++;
        }

        return (int) Math.pow(2, count);
    }
}