class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];

        // Count occurrences using streams
        IntStream.range(0, nums.length)
                .forEach(i -> count[nums[i]]++);

        // Fill nums using flatMap and forEachOrdered
        int[] sorted = IntStream.range(0, 3)
                .flatMap(i -> IntStream.range(0, count[i]).map(j -> i))
                .toArray();

        // Copy back to the original array
        IntStream.range(0, nums.length)
                .forEach(i -> nums[i] = sorted[i]);
    }
}