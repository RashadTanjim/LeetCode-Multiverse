class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pollLast();
            } else {
                stack.addLast(c);
            }
        }

        // Convert stack to string
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}