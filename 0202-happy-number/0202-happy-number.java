class Solution {
    public boolean isHappy(int n) {
        for (int i = 0; i < 100; i++) { // Arbitrary limit to avoid infinite loops
            int squareSum = 0;
            while (n > 0) {
                int digit = n % 10;
                squareSum += digit * digit;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            n = squareSum;
        }
        return false;
    }
}
