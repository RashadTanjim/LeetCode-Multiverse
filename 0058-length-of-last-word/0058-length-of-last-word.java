class Solution {
    public int lengthOfLastWord(String s) {

        int length = 0;
        boolean count = false;

        for (char c : s.toCharArray()) {

            if (c != ' ') {

                if (!count) {

                    count = true;
                    length = 1;
                } else {
                    length++;
                }
            } else {
                count = false;
            }
        }

        return length;

        // var arr = s.split(" ");
        // String lastWord = arr[arr.length - 1];
        // return lastWord.length();
    }
}