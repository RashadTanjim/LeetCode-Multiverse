class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, new ArrayList<>(), n, k, result);
        return result;
    }

    private void backtrack(int start, List<Integer> path, int n, int k, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, path, n, k, result);
            path.removeLast();
        }
    }
}