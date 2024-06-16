class Solution {
    public int minPatches(int[] nums, int n) {
        
        long miss = 1;  // Start with the smallest number we need to cover
        int i = 0;      // Index to traverse the nums array
        int patches = 0; // Number of patches added

        while (miss <= n) {
            
            if (i < nums.length && nums[i] <= miss) {
                
                // If nums[i] can contribute to forming the number `miss`
                miss += nums[i];
                i++;
                
            } else { // Otherwise, patch the array with `miss`
                miss += miss;
                patches++;
            }
        }

        return patches;
    }
}