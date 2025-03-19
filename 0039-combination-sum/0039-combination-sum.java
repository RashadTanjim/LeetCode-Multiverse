class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index, int[] candidates, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (candidates[i] <= target) {
                path.add(candidates[i]);
                backtrack(i, candidates, target - candidates[i], path, result);
                path.removeLast(); // Backtrack
            }
        }
    }
}