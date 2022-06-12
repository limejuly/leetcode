/*
 * @lc app=leetcode id=1658 lang=java
 *
 * [1658] Minimum Operations to Reduce X to Zero
 * 
 * 想法 1: 错的. 贪心算法. 每次选择头尾元素, 只要不超过当前 x, 就选最大的. 最大的有利于达到最少步数. (但是是错的. 因为有可能一边虽然最大, 但是导致后面无法加到 x. 而另一边可能小一点, 但是可以, 却没法被选择.)
 * 
 * 解法 1: 巧思. 注意到从两边挑选元素, 要求步数最小, 相当于选择中间剩下的元素, 长度最长. 而中间元素是连续的, 可以线性时间找到.
 * 解法 2: 因为选取元素必然在头和尾连续, 所以算从头开始的 presum, 存到 map. 再算从尾开始的 suffixsum, 如果某个 suffixsum 可以找到加起来为 x 的 presum, 则把它作为候选min step.
 * 解法 3: is dp possible?
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int count = 0;
        int start = 0;
        int end = nums.length - 1;
        while (x > 0 && start <= end) {
            int min = Math.min(nums[start], nums[end]);
            int max = Math.max(nums[start], nums[end]);
            if (x >= max) {
                x -= max;
                if (nums[start] <= nums[end]) {
                    end--;
                } else {
                    start++;
                }
            } else {
                x -= min;
                if (nums[start] <= nums[end]) {
                    start++;
                } else {
                    end--;
                }
            }
            count++;
        }
        System.out.println(count);
        if (x == 0) {
            return count;
        } else {
            return -1;
        }
    }
}
// @lc code=end
