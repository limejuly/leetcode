import java.util.*;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        int v = k - root.val;
        if (map.containsKey(v))
            return true;

        map.put(root.val, root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
// @lc code=end
