/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i = nums.length - 1, j = 0;
        for (int k = 0; k < nums.length - 1; k++) {
            if (nums[k] > nums[k + 1]) {
                i = k;
                break;
            }
        }
        for (int k = nums.length - 1; k > 1; k--) {
            if (nums[k] < nums[k - 1]) {
                j = k;
                break;
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
        }
        System.out.println(i + ":" + j + ":" + min + ":" + max);

        for (int k = i; k >= 0; k--) {
            if (nums[k] > min) {
                i = k;
            }
        }
        for (int k = j; k < nums.length; k++) {
            if (nums[k] < max) {
                j = k;
            }
        }
        System.out.println(i + ":" + j);
        return j - i > 0 ? j - i + 1 : 0;
    }
}
// @lc code=end
