
/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 * 思路: 对于 root, 它可能涉及的最小 difference 是, 与左边最大的, 和右边最小的. 再递归地求左右子树中是否有比这还小的.
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
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (root.left != null) {
            int l = findLargest(root.left);
            left = Math.min(root.val - l, getMinimumDifference(root.left));
        }
        if (root.right != null) {
            int s = findSmallest(root.right);
            right = Math.min(s - root.val, getMinimumDifference(root.right));
        }
        return Math.min(left, right);
    }

    private int findLargest(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    private int findSmallest(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
// @lc code=end
