/*
 * @lc app=leetcode id=1749 lang=java
 *
 * [1749] Maximum Absolute Sum of Any Subarray
 * 
 * dp. 两个 dp 数组, 一个保存累加最大值, 一个保存累加最小值. 在所有 dp 值里找绝对值最大的.
 */

// @lc code=start
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int pos = 0, neg = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            neg = Math.min(neg + nums[i], nums[i]);
            pos = Math.max(pos + nums[i], nums[i]);
            int larger = Math.max(Math.abs(neg), Math.abs(pos));
            max = Math.max(max, larger);
        }
        return max;
    }
}
// @lc code=end
