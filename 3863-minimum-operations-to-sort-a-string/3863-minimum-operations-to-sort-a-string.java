
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] sorted = s.toCharArray();
        java.util.Arrays.sort(sorted);

        String target = new String(sorted);

        // Already sorted
        if (s.equals(target)) {
            return 0;
        }

        // A substring cannot be the entire string
        if (n == 2) {
            return -1;
        }

        int left = 0;
        int right = n - 1;

        // Find the first and last mismatching positions
        while (s.charAt(left) == target.charAt(left)) {
            left++;
        }

        while (s.charAt(right) == target.charAt(right)) {
            right--;
        }

        // A proper substring can fix the string in one operation
        if (left > 0 || right < n - 1) {
            return 1;
        }

        char first = s.charAt(0);
        char last = s.charAt(n - 1);

        char max = sorted[n - 1];
        char min = sorted[0];

        // Special case: maximum at the start and minimum at the end
        if (first == max && last == min) {
            if (s.indexOf(first) != s.lastIndexOf(first)
                    || s.indexOf(last) != s.lastIndexOf(last)) {
                return 2;
            }
            return 3;
        }

        return 2;
    }
}
