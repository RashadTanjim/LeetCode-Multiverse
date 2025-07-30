class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        for (int i = 0; i < 32; i++) {
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;
            int cBit = (c >> i) & 1;

            int orBit = aBit | bBit;

            if (orBit == cBit) {
                continue; // no flips needed
            }

            if (cBit == 0) {
                flips += aBit + bBit; // need to flip 1s to 0
            } else {
                flips += 1; // cBit == 1 but orBit == 0 â flip one to 1
            }
        }

        return flips;
    }
}