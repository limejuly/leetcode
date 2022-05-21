/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int dp = nums[0];
        int dpa = dp;
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            int temp_dp = max(nums[i], nums[i] * dp, nums[i] * dpa);
            dpa = min(nums[i], nums[i] * dp, nums[i] * dpa);
            dp = temp_dp;
            max = Math.max(max, dp);
            System.out.println(String.format("%d %d %d", nums[i], dp, dpa));
        }
        return max;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
// @lc code=end
