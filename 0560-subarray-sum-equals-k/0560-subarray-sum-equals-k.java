class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefSum = new HashMap<>();
        int count = 0, sum = 0;

        prefSum.put(0, 1); // base case

        for (int num : nums) {
            sum += num;

            if (prefSum.containsKey(sum - k)) {
                count += prefSum.get(sum - k);
            }

            prefSum.put(sum, prefSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}