class Solution {
    public int maxArea(int[] height) { // two pointer approach

        int start = 0, end = height.length - 1, maxArea = 0;

        while (start < end) {
            // MaxArea -> height * min width from start or end
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}