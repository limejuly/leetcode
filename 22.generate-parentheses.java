import java.util.*;
/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrace(sb, 0, 0, 2 * n, res);
        return res;
    }

    public void backTrace(StringBuilder current, int open, int close, int target, List<String> res) {
        if (current.length() == target) {
            res.add(current.toString());
        } else {
            if (open < target / 2) {
                current.append('(');
                backTrace(current, open + 1, close, target, res);
                current.deleteCharAt(current.length() - 1);
            }

            if (close < open) {
                current.append(')');
                backTrace(current, open, close + 1, target, res);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
// @lc code=end
