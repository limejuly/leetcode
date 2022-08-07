/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 * 
 * 简单. 子数组长度固定为 k
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, j = k - 1;
        int sum = 0;
        for (int l = i; l <= j && l < nums.length; l++) {
            sum += nums[l];
        }
        int max = sum;
        while (j < nums.length - 1) {
            sum += nums[++j];
            sum -= nums[i++];
            max = Math.max(max, sum);
        }

        return max * 1.0 / k;

    }
}
// @lc code=end
