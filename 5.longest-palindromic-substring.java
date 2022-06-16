/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String str = longestPalindrome(s, i, i);
            if (str.length() > max.length()) {
                max = str;
            }
            String str2 = longestPalindrome(s, i, i + 1);
            if (str2.length() > max.length()) {
                max = str2;
            }
        }
        return max;
    }

    public String longestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        // seems always have to step back
        if (l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)) {
            l++;
            r--;
        }
        return s.substring(l, r + 1);
    }
}
// @lc code=end
