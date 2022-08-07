/*
 * @lc app=leetcode id=862 lang=java
 *
 * [862] Shortest Subarray with Sum at Least K
 */

// @lc code=start
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= k) {
                res = Math.min(res, right - left + 1);

                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
// @lc code=end
