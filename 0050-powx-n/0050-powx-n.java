class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        long power = n;
        if (n < 0) {
            x = 1 / x; // Handle negative exponent
            power = -power; // Convert to positive
        }

        double result = 1.0;
        while (power > 0) {

            if ((power & 1) == 1) { // If current bit is set, multiply
                result *= x;
            }

            x *= x; // Square x
            power >>= 1; // Divide power by 2
        }

        return result;
    }
}