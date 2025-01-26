class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        int result = 0;

        if (n < 1)
            return 0;

        while (left < right) {

            if (leftMax < rightMax) {
                left++;
                leftMax = leftMax > height[left] ? leftMax : height[left];
                result += leftMax - height[left];

            } else {
                right--;
                rightMax = rightMax > height[right] ? rightMax : height[right];
                result += rightMax - height[right];
            }
        }

        return result;
    }
}