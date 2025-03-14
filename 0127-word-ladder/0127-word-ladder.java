class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] wordArray = currentWord.toCharArray();

                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];

                    // Try all letters from 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String newWord = new String(wordArray);

                        // If newWord is in the other set, we have found a path
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If newWord exists in wordSet and hasn't been visited
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }

                    wordArray[j] = originalChar; // Restore the original character
                }
            }
            level++;
        }

        return 0;
    }
}