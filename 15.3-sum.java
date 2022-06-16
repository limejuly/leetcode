import java.util.*;
/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 * 
 * 注意两个地方都要去重
*/

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            twoSum(nums, i + 1, nums.length - 1, first, res);
        }
        return res;
    }

    public void twoSum(int[] nums, int l, int r, int first, List<List<Integer>> res) {
        int sum = 0 - first;
        while (l < r) {
            int twosum = nums[l] + nums[r];
            if (twosum < sum) {
                l++;
            } else if (twosum > sum) {
                r--;
            } else {
                List<Integer> pairs = new ArrayList<>();
                pairs.add(first);
                pairs.add(nums[l]);
                pairs.add(nums[r]);
                res.add(pairs);

                int nl = nums[l];
                while (l < nums.length && nums[l] == nl)
                    l++;
                int nr = nums[r];
                while (r > 0 && nums[r] == nr)
                    r--;
            }
        }
    }
}
// @lc code=end
