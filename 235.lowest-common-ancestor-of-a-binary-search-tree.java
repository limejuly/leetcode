/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if (root == null) {
           return null;
       }
       // both in left
       if (p.val < root.val && q.val < root.val) {
           return lowestCommonAncestor(root.left, p,q);
       }
       // both in right
       if (p.val > root.val && q.val > root.val) {
           return lowestCommonAncestor(root.right, p, q);
       }

       // one in left, one in right. or at least one is root
       return root;
    }
}
// @lc code=end

