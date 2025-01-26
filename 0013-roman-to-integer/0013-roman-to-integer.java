class Solution {
    public int romanToInt(String s) {

        int ans = 0, num = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            switch (s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }

            if (4 * num < ans)
                ans -= num;
            else
                ans += num;
        }

        return ans;

        // Map<Character, Integer> roman = new HashMap<>();
        // roman.put('I', 1);
        // roman.put('V', 5);
        // roman.put('X', 10);
        // roman.put('L', 50);
        // roman.put('C', 100);
        // roman.put('D', 500);
        // roman.put('M', 1000);

        // int result = 0;
        // int n = s.length();

        // for (int i = 0; i < n; i++) {

        // if (i + 1 < n && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
        // result -= roman.get(s.charAt(i));
        // } else {
        // result += roman.get(s.charAt(i));
        // }
        // }

        // return result;
    }
}