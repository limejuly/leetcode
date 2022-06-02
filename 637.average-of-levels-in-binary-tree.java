import java.util.*;

/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 * 涉及到层序遍历, 需要一个 Queue. 并且每层单独计算, 还要一个 num 计算每层应该有的 node 数.
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelNums = 1;
        while (!queue.isEmpty()) {
            long sum = 0;
            int nextLevelNums = 0;
            for (int i = 0; i < levelNums; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {

                    queue.offer(node.left);
                    nextLevelNums++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelNums++;
                }
            }
            res.add(sum * 1.0 / levelNums);
            levelNums = nextLevelNums;
        }
        return res;
    }
}
// @lc code=end
