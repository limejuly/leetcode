/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 * 
 * 滑动窗口. 每次右边扩 1 位, 只要当前窗口prod<k, 那么每个元素以及sub都是<k, 所以增加 right-left+1 个符合的结果.
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        long prod = 1;
        int left = 0, right = 0;
        while (right < nums.length) {
            prod *= nums[right];

            while (left <= right && prod >= k) {
                prod /= nums[left];
                left++;
            }

            res += right - left + 1;
            right++;
        }
        return res;
    }
}
// @lc code=end
