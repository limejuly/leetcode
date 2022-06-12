
/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;

        return leftLeaves(root.left, true) + leftLeaves(root.right, false);
    }

    public int leftLeaves(TreeNode root, boolean isLeft) {
        if (root == null)
            return 0;
        if (root.right == null && root.left == null && isLeft) {
            return root.val;
        }
        return leftLeaves(root.left, true) + leftLeaves(root.right, false);
    }
}
// @lc code=end
