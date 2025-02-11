class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26]; // Array to count frequency of each character

            // Count frequency of characters
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert the frequency count array to a string (for use as a key)
            StringBuilder key = new StringBuilder();
            for (int c : count) {
                key.append("#"); // Separate frequencies for better uniqueness
                key.append(c);
            }

            // Group anagrams based on the frequency count
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}