class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        // Count occurrences of characters in the magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if we can construct the ransomNote from the magazine
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false; // Not enough characters in magazine
            }
            count[c - 'a']--; 
        }

        return true;
    }
}

// class Solution {
// public boolean canConstruct(String ransomNote, String magazine) {

// HashMap<Character, Integer> map = new HashMap<>();

// for (char c : magazine.toCharArray()) {
// map.put(c, map.getOrDefault(c, 0) + 1);
// }

// for (char c : ransomNote.toCharArray()) {
// if (!map.containsKey(c) || map.get(c) <= 0) {
// return false;
// }
// map.put(c, map.get(c) - 1);
// }

// return true;
// }
// }