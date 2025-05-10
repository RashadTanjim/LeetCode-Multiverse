class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length())
            return result;

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq, sFreq))
            result.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
            sFreq[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pFreq, sFreq))
                result.add(i - p.length() + 1);
        }

        return result;
    }
}