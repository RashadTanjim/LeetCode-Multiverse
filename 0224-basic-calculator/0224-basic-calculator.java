class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int num = 0, result = 0, sign = 1; // `sign = 1` means positive, `-1` means negative

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // Extract full number

            } else if (c == '+' || c == '-') {
                result += sign * num;
                num = 0;
                sign = c == '+' ? 1 : -1;

            } else if (c == '(') {
                stack.push(result); // Store the current result
                stack.push(sign); // Store the current sign
                result = 0;
                sign = 1;

            } else if (c == ')') {
                result += sign * num; // Complete the last pending operation
                num = 0;
                result *= stack.pop(); // Apply sign before '('
                result += stack.pop(); // Add result before '('
            }
        }

        return result + (sign * num); // Add last number to result

    }
}