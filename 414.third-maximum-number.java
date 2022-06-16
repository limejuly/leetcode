/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 */

// @lc code=start
class Solution {
    // three iterations
    // notice that value may be Integer.MIN_VALUE
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int num : nums) {
            first = Math.max(first, num);
        }
        for (int num : nums) {
            if (num == first)
                continue;
            second = Math.max(second, num);
        }
        boolean hasThird = false;
        for (int num : nums) {
            if (num == first || num == second)
                continue;
            hasThird = true;
            third = Math.max(third, num);
        }

        return hasThird ? third : first;
    }
}
// @lc code=end
