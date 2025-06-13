class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0, maxAltitude = 0;

        for (int i : gain) {
            altitude += i;
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }
}