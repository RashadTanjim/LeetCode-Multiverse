class Solution {
    public int myAtoi(String s) {
        
        int index = 0, sign = 1, total = 0;
        int n = s.length();
        
        // Check if the string is empty
        if (n == 0) return 0;
        
         // Triming whitespaces --> 1. Whitespace: Ignore any leading whitespace (" ").
         while (index < n && s.charAt(index) == ' ') {
            index++;
         }
        
        
        // removing whitespaces, if the index is 0 or not 
        if (index == n) return 0;
        
        
        // --> 2. Signedness: checking if the next character is '-' or '+'
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }
        
        // Convert the number and avoid non-digit characters --> 3. Rounding: If the integer 
        while (index < n) {
             
            char currentChar = s.charAt(index);
             
            if (currentChar < '0' || currentChar > '9') break;

            // Check for overflow and underflow
            if (total > (Integer.MAX_VALUE - (currentChar - '0')) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // Append current digit to the total
            total = total * 10 + (currentChar - '0');
            index++;
        }
        
        // --> Return the final result with the correct sign
        return total * sign;
    }
}
