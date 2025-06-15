class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1)
            set1.add(n);
            
        for (int n : nums2)
            set2.add(n);

        List<Integer> onlyInNums1 = new ArrayList<>();
        List<Integer> onlyInNums2 = new ArrayList<>();

        for (int n : set1) {
            if (!set2.contains(n)) {
                onlyInNums1.add(n);
            }
        }

        for (int n : set2) {
            if (!set1.contains(n)) {
                onlyInNums2.add(n);
            }
        }

        return List.of(onlyInNums1, onlyInNums2);
    }
}