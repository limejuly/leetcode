/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 * 
 * TODO : 还有问题
 */

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        int presum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            presum = (presum + nums[i]) % k;
            if (presum < 0) {
                presum += k;
            }
            if (map.containsKey(presum)) {
                return true;
            }

            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return false;
    }
}
// @lc code=end
