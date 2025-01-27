class Solution {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String firstEliment = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(firstEliment) != 0) {
                firstEliment = firstEliment.substring(0, firstEliment.length() - 1);
            }
        }
        return firstEliment;
    }
}