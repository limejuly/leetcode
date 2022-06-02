import java.util.Map;

/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
    public int[] findMode(TreeNode root) {
        traverse(root);
        return map.entrySet().stream().filter(
                entry -> entry.getValue() == max).mapToInt(entry -> entry.getKey()).toArray();
    }

    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        int value = map.containsKey(root.val) ? map.get(root.val) + 1 : 1;
        map.put(root.val, value);
        max = Math.max(max, value);

        traverse(root.left);
        traverse(root.right);
    }
}
// @lc code=end
