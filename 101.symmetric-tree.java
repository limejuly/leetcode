/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);

    }

    public boolean isSym(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isSym(t1.left, t2.right) && isSym(t1.right, t2.left);
    }
}
// @lc code=end
