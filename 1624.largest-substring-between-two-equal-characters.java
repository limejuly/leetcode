/*
 * @lc app=leetcode id=1624 lang=java
 *
 * [1624] Largest Substring Between Two Equal Characters
 * 
 * 1. 取巧: 因为字母只有小写字母 26 个, 可以遍历一遍, 记住每个的开始和最大结束位置.
 * 2. 子串的正路: ?????
 * 
 */

// @lc code=start
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] begin = new int[26];
        int[] end = new int[26];
        Arrays.fill(begin, -1);
        Arrays.fill(end, -1);
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ind = ch - 'a';
            if (begin[ind] == -1) {
                begin[ind] = i;
            } else if (end[ind] < i) {
                end[ind] = i;
                max = Math.max(max, end[ind] - begin[ind] - 1);
            }
        }
        return max;
    }
}
// @lc code=end
