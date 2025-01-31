class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sorting the array (O(n log n))

        for (int i = 0; i < nums.length - 2; i++) { // Avoid unnecessary iterations
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicates for i

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Move pointers to avoid duplicates
                    while (j < k && nums[j] == nums[j + 1])
                        j++; // Skip duplicate for j
                    while (j < k && nums[k] == nums[k - 1])
                        k--; // Skip duplicate for k

                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
