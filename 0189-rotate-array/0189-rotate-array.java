class Solution {
    public void rotate(int[] nums, int k) {

        int len = nums.length;
        k = k % len;

        reversed(nums, 0, len - 1); // reverse full array
        reversed(nums, 0, k - 1); // reverse till k-th elements
        reversed(nums, k, len - 1); // reverse las elements
    }

    private void reversed(int[] nums, int p1, int p2) {

        while (p1 < p2) { // swaping values
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;
        }
    }
}
