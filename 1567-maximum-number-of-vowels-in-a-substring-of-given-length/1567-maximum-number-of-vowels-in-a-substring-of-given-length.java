class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int maxVowels = 0, currVowels = 0;

        for (int i = 0; i < s.length(); i++) {

            if (vowels.contains(s.charAt(i))) {
                currVowels++;
            }

            if (i >= k && vowels.contains(s.charAt(i - k))) {
                currVowels--;
            }

            maxVowels = Math.max(maxVowels, currVowels);
        }

        return maxVowels;
    }
}