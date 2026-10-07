class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        int left = 0;
        int right = 0;

        // Find how many '(' and ')' need to be removed
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                left++;
            } 
            else if (ch == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, result);

        return result;
    }

    private void dfs(String s, int start, int leftRem,
                     int rightRem, List<String> result) {

        // All required removals are done
        if (leftRem == 0 && rightRem == 0) {

            if (isValid(s)) {
                result.add(s);
            }

            return;
        }

        for (int i = start; i < s.length(); i++) {

            // Skip duplicate parentheses
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            // Remove '('
            if (leftRem > 0 && s.charAt(i) == '(') {

                String newString =
                    s.substring(0, i) + s.substring(i + 1);

                dfs(newString, i, leftRem - 1,
                    rightRem, result);
            }

            // Remove ')'
            if (rightRem > 0 && s.charAt(i) == ')') {

                String newString =
                    s.substring(0, i) + s.substring(i + 1);

                dfs(newString, i, leftRem,
                    rightRem - 1, result);
            }
        }
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            } 
            else if (ch == ')') {

                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}