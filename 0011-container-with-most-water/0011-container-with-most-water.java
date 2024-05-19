class Solution {
    public int maxArea(int[] height) {
        
        int firstIndex = 0, secondIndex = height.length - 1, maxAmount = 0;
        
        while(firstIndex < secondIndex) {
            
            if(height[firstIndex] < height[secondIndex]) {
                
                maxAmount =  (maxAmount > height[firstIndex] * (secondIndex - firstIndex)) ?
                    maxAmount : height[firstIndex] * (secondIndex - firstIndex);
                
                firstIndex += 1;
                
            }  else {
                
                maxAmount = (maxAmount > height[secondIndex] * (secondIndex - firstIndex)) ?
                    maxAmount : height[secondIndex] * (secondIndex - firstIndex);
                
                secondIndex -= 1;
            }
        }
        
        return maxAmount;
    }
}