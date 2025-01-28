class Solution {
    public int strStr(String haystack, String needle) { // Time complexity: O(nâm) || Space complexity: O(1)

        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            if (haystack.substring(i, i + needle.length()).equals(needle)) { // sliding window approach
                return i;
            }
        }

        return -1;
    }
}