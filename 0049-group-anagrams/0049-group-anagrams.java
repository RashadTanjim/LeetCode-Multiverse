class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> words = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String word = new String(chars);
            if (!words.containsKey(word)) {
                words.put(word, new ArrayList<>());
            }

            words.get(word).add(str);
        }

        return new ArrayList<>(words.values());
    }
}