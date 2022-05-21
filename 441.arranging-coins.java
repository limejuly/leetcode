/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        long left = 0;
        long right = n;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long sum = sum(mid);
            if (n >= sum && n < sum(mid + 1)) {
                return (int) mid;
            } else if (n < sum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) (left);
    }

    public long sum(long i) {
        return (long) i * (i + 1) / 2;
    }
}

// @lc code=end
