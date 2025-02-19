class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {

                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand

                int result = cal(a, b, token);

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();

    }

    private int cal(int a, int b, String operator) {

        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}