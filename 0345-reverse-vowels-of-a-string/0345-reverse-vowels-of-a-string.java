class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0)
            return s;

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'));

        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;

        while (i < j) {
            while (i < j && !vowels.contains(chars[i])) {
                i++;
            }

            while (i < j && !vowels.contains(chars[j])) {
                j--;
            }

            if (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }

        return new String(chars);
    }
}