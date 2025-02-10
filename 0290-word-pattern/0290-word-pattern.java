class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length)
            return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> mappedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(c)) {

                if (!map.get(c).equals(word))
                    return false;

            } else {

                if (mappedWords.contains(word))
                    return false;

                map.put(c, word);
                mappedWords.add(word);
            }
        }

        return true;
    }
}