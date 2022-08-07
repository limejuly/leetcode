/*
 * @lc app=leetcode id=1800 lang=java
 *
 * [1800] Maximum Ascending Subarray Sum
 */

// @lc code=start
class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = nums[i] > nums[i - 1] ? sum + nums[i] : nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
// @lc code=end
