class Solution {
    public String reverseWords(String s) {

        String[] arr = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {

            reversed.append(arr[i]);

            if (i != 0) { // Add a space between words, but not after the last word
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}