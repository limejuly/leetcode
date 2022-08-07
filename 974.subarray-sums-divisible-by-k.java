import java.util.Map;

/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 * 
 * find some (presum[i]-presum[j])%5 == 0, equals 
 * find some presum[i]%5 == presum[j]%5
 * 
 * 另外要注意和为负数情况. python 里面会自动转正数, java 不会.
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int presum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            presum = (presum + nums[i]) % k;
            if (presum < 0) {
                presum += k;
            }
            if (map.containsKey(presum)) {
                res += map.get(presum);
            }

            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return res;
    }
}
// @lc code=end
