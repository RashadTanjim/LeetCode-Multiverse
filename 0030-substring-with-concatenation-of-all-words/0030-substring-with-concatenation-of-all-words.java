import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0)
            return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int windowLen = wordLen * wordCount;

        if (s.length() < windowLen)
            return result;

        // Store word frequency
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Iterate over possible start positions
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seenWords = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

                    // checks if the current window has more occurrences of word than allowed
                    while (seenWords.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLen;
                    }

                    if (right - left == windowLen) {
                        result.add(left);
                    }
                } else {
                    // Reset everything if word not found
                    seenWords.clear();
                    left = right;
                }
            }
        }

        return result;
    }
}
