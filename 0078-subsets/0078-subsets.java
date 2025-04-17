class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        createSubset(nums, 0, result, subset);
        return result;
    }

    private void createSubset(int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        createSubset(nums, index + 1, result, subset);

        subset.remove(subset.removeLast());
        createSubset(nums, index + 1, result, subset);
    }
}