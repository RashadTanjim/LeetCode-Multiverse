class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabets = new int[26];

        for (char c : s.toCharArray()) {
            alphabets[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            alphabets[c - 'a']--;
        }

        for (int alphabet : alphabets) {
            if (alphabet != 0) {
                return false;
            }
        }

        return true;
    }
}