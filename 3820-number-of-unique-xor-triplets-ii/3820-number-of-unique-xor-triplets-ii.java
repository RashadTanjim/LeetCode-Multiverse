class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> pairs = new HashSet<>(List.of(0));
        for (int i = 0, n = nums.length; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                pairs.add(nums[i] ^ nums[j]);
            }
        }

        BitSet triplets = new BitSet();
        for (int xy : pairs) {
            for (int z : nums) {
                triplets.set(xy ^ z);
            }
        }

        return triplets.cardinality();
    }
}