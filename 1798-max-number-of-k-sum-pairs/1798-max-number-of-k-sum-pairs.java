class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int complement = k - num;

            if (freq.getOrDefault(complement, 0) > 0) {
                count++;
                freq.put(complement, freq.get(complement) - 1);
            } else {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }
}