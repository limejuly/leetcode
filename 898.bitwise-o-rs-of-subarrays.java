/*
 * @lc app=leetcode id=898 lang=java
 *
 * [898] Bitwise ORs of Subarrays
 *  
 * dp 
 */

// @lc code=start
class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (int x : A) {
            Set<Integer> cur2 = new HashSet();
            for (int y : cur)
                cur2.add(x | y);
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();
    }
}
// @lc code=end
