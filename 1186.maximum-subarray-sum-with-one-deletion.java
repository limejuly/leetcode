/*
 * @lc app=leetcode id=1186 lang=java
 *
 * [1186] Maximum Subarray Sum with One Deletion
 * 
 * dp. 保存两个状态.
 */

// @lc code=start
class Solution {
    public int maximumSum(int[] nums) {
        int a = nums[0];
        int b = 0;
        int res = a;
        for (int i = 1; i < nums.length; i++) {
            b = Math.max(b + nums[i], a);
            a = Math.max(a + nums[i], nums[i]);
            res = Math.max(res, Math.max(a, b));
            System.out.println(i + ":" + b + ":" + a);
        }
        return res;
    }
}
// @lc code=end
