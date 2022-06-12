/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {

    int[] pre;

    public NumArray(int[] nums) {
        pre = new int[nums.length + 1];
        pre[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

    }

    public int sumRange(int left, int right) {
        return pre[right + 1] - pre[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end
