/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSmaller(root.val, root.left) && isLarger(root.val, root.right) && isValidBST(root.left)
                && isValidBST(root.right);
    }

    public boolean isSmaller(int val, TreeNode root) {
        if (root == null) {
            return true;
        }
        return root.val < val && isSmaller(val, root.left) && isSmaller(
                val, root.right);
    }

    public boolean isLarger(int val, TreeNode root) {
        if (root == null) {
            return true;
        }
        return root.val > val && isLarger(val, root.left) && isLarger(
                val, root.right);
    }
}
// @lc code=end
