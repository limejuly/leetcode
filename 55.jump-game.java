/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int farest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farest = Math.max(farest, i + nums[i]);
            if (farest <= i) {
                return false;
            }
        }
        return farest >= nums.length - 1;
    }
}
// @lc code=end
