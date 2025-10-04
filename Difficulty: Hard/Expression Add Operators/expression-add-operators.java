import java.util.*;

class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        helper(s, target, 0, 0, 0, "", result);
        Collections.sort(result); // Lexicographically smallest order
        return result;
    }

    private void helper(String s, int target, int index, long currVal, long prevNum,
                        String expr, ArrayList<String> result) {
        // Base case: reached the end of string
        if (index == s.length()) {
            if (currVal == target) {
                result.add(expr);
            }
            return;
        }

        // Try all possible splits of the remaining string
        for (int i = index; i < s.length(); i++) {
            // If the number starts with '0' and has more than one digit, skip (avoid leading zero)
            if (i != index && s.charAt(index) == '0') break;

            String part = s.substring(index, i + 1);
            long currNum = Long.parseLong(part);

            // First number (no operator before it)
            if (index == 0) {
                helper(s, target, i + 1, currNum, currNum, part, result);
            } else {
                // Try '+'
                helper(s, target, i + 1, currVal + currNum, currNum, expr + "+" + part, result);

                // Try '-'
                helper(s, target, i + 1, currVal - currNum, -currNum, expr + "-" + part, result);

                // Try '*'
                helper(s, target, i + 1, currVal - prevNum + prevNum * currNum,
                        prevNum * currNum, expr + "*" + part, result);
            }
        }
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findExpr("124", 9));  // ["1+2*4"]
        System.out.println(sol.findExpr("125", 7));  // ["1*2+5", "12-5"]
        System.out.println(sol.findExpr("12", 12));  // ["12"]
        System.out.println(sol.findExpr("987612", 200)); // []
    }
}
