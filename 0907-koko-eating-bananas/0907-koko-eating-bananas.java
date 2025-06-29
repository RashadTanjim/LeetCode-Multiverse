class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canFinish(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean canFinish(int[] piles, int k, int h) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil(pile / k)
        }

        return hours <= h;
    }

}