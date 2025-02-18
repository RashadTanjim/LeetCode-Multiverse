class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");

        for (String dir : split) {

            if (dir.equals("..")) {

                if (!stack.isEmpty())
                    stack.pop();

            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        return "/" + String.join("/", stack);
    }
}