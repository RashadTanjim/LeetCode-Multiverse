class Solution {
    public int mySqrt(int x) {
        if (x < 2)
            return x;

        long num;
        int mid, low = 2, high = x / 2;

        while (low <= high) {
            mid = low + high >>> 1;
            num = (long) mid * mid;

            if (num > x) {
                high = mid - 1;
            } else if (num < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return high;
    }
}