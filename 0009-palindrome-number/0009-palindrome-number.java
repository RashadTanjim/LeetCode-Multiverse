class Solution {
    public boolean isPalindrome(int x) {

        String temp = Integer.toString(x);
        String reverse = "";

        for(int i = 0; i < temp.length(); i++) {
            reverse = temp.charAt(i) + reverse;
        }

        return (temp.equals(reverse)) ? true : false;        
    }
}
