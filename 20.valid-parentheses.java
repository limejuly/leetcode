/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    continue;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char sch = stack.pop();
                    if (sch != map.get(ch)) {
                        return false;
                    }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
// @lc code=end
