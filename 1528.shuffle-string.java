/*
 * @lc app=leetcode id=1528 lang=java
 *
 * [1528] Shuffle String
 */

// @lc code=start
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] news = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int newp = indices[i];
            news[newp] = s.charAt(i);
        }
        return new String(news);
    }
}
// @lc code=end
