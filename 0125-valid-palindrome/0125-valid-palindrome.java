class Solution {
    public boolean isPalindrome(String s) { // two pinter approach

        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int start = 0, end = s.length() - 1;

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}