/*
 * @lc app=leetcode id=1094 lang=java
 *
 * [1094] Car Pooling
 * tag: 差分数组 
 * 这题要注意的是给的区间 start end 是从 0 开始的, 而且 end 是下车点, 是 exclusive 的.
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];

        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            int start = trip[1];
            int end = trip[2];
            int count = trip[0];

            arr[start] += count;
            arr[end] -= count;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
