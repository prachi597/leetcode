class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        int result = 0;
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > INT_MAX / 10 || 
               (result == INT_MAX / 10 && digit > 7)) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}