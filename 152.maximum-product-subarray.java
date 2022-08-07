/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 * 
 * dp 简化. 一个 dp_max 保存目前为止的最大值. 最大值是当前元素, 当前元素乘之前的最大值, 当前元素乘之前的最小值, 三者的最大值. 最小值同样. 注意最小值用的是之前的 max, 要临时保存一下.
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int min = 1;
        int max = 1;
        for (int num : nums) {
            int tempMax = max;
            max = max(max * num, min * num, num);
            min = min(tempMax * num, min * num, num);
            res = Math.max(res, max);
        }
        return res;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
// @lc code=end
