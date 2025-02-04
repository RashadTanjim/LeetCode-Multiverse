class Solution {
    public String minWindow(String s, String t) {
        // checking base cases
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        int count = t.length();
        int start = 0, minLen = Integer.MAX_VALUE, startIndex = 0;

        for (char ch : t.toCharArray()) { // creating a int map to store char frequency
            map[ch]++;
        }

        for (int end = 0; end < s.length(); end++) {
            // If character at `end` exists in `t`, decrement the count
            if (map[s.charAt(end)]-- > 0) {
                count--;
            }

            while (count == 0) {
                // Update minimum window size and starting index
                if (end - start + 1 < minLen) {
                    startIndex = start;
                    minLen = end - start + 1;
                }

                // Try to shrink the window from the left
                if (map[s.charAt(start)]++ == 0) {
                    count++;
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}