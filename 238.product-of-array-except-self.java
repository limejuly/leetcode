/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int end = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; i--) {
            res[i] = res[i] * end;
            end = end * nums[i];
        }
        res[0] = end;
        return res;
    }
}
// @lc code=end
