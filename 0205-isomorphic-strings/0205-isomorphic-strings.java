class Solution {
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<>();
        Set<Character> mappedValues = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (map.containsKey(charS)) {
                if (map.get(charS) != charT)
                    return false; // Conflict
            } else {
                if (mappedValues.contains(charT))
                    return false; // Prevent multiple mappings
                map.put(charS, charT);
                mappedValues.add(charT);
            }
        }

        return true;
    }
}