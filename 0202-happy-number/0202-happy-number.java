class Solution {
    // Floydâs Cycle Detection (Tortoise and Hare)
    public boolean isHappy(int n) {

        int slow = n, fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast)); // Move fast twice
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int squareSum = 0;

        while (n > 0) {
            int digit = n % 10;
            squareSum += digit * digit;
            n /= 10;
        }

        return squareSum;
    }
}
