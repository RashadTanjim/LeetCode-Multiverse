class Solution {

    public int minIncrementForUnique(int[] nums) {
        
        // Sort the array
        Arrays.sort(nums);
        
        int moves = 0;
        
        for (int i = 1; i < nums.length; i++) {
            // If the current number is not greater than the previous number, 
            // it means it's a duplicate or smaller
            
            if (nums[i] <= nums[i - 1]) {
                
                // Calculate how many moves are needed to make nums[i] unique
                int increment = nums[i - 1] - nums[i] + 1;
                
                // Add the number of moves to the total moves count
                moves += increment;
                
                // Update the current number to the new unique value
                nums[i] += increment;
            }
        }
        
        return moves;
    }
}