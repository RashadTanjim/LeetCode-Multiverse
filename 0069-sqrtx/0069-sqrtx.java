class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;

        int low = 1, high = x, ans = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                ans = mid;
                low = low + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}