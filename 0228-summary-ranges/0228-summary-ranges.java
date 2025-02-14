class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        int i = 0, n = nums.length;

        while (i < n) {
            int start = i;

            while (i + 1 < n && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            
            result.add(formatRange(nums[start], nums[i]));
            i++;
        }

        return result;
    }

    private String formatRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : start + "->" + end;
    }
}