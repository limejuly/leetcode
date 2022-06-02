/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int h = height(root.left) - height(root.right);
        return (h<=1 && h>=-1)&& isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right))+1;
    }
}
// @lc code=end

