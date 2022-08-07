/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 * 
 * 滑动窗口. 要注意没有解的情况.
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                res = Math.min(res, right - left + 1);

                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
// @lc code=end
