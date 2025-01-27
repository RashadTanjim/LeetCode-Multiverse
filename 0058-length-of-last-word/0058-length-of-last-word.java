class Solution {
    public int lengthOfLastWord(String s) {

        String[] words = s.split(" ");
        return words[words.length - 1].length();

        // int length = 0;
        // boolean count = false;

        // for (char c : s.toCharArray()) {

        // if (c != ' ') {

        // if (!count) {

        // count = true;
        // length = 1;
        // } else {
        // length++;
        // }
        // } else {
        // count = false;
        // }
        // }
        // return length;

    }
}