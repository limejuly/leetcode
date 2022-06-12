/*
 * @lc app=leetcode id=1109 lang=java
 *
 * [1109] Corporate Flight Bookings
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n + 1];
        for (int[] booking : bookings) {
            int from = booking[0];
            int to = booking[1];
            int num = booking[2];
            arr[from - 1] += num;
            arr[to] -= num;
        }

        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            res[i] = sum;
        }
        return res;
    }
}
// @lc code=end
