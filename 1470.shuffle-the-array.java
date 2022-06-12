import java.util.*;

/*
 * @lc app=leetcode id=1470 lang=java
 *
 * [1470] Shuffle the Array
 */

// @lc code=start
class Solution {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = i + n;
            res.add(nums[i]);
            res.add(nums[j]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
// @lc code=end
