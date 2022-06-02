
/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */
import java.util.*;
import java.util.stream.Collectors;

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
// 递归回溯
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            rec(root, "", res);
        }
        return res;

    }

    public void rec(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        if (root.left != null) {
            rec(root.left, path + root.val + "->", res);
        }
        if (root.right != null) {
            rec(root.right, path + root.val + "->", res);
        }
    }
}
// @lc code=end

// 迭代回溯
class Solution1 {
    List<String> res = new ArrayList<>();
    List<Integer> current = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            traverse(root);
        }
        return res;
    }

    public void traverse(TreeNode root) {
        current.add(root.val);

        if (root.left == null && root.right == null) {
            res.add(toStr(current));
        }
        if (root.left != null) {
            traverse(root.left);
        }
        if (root.right != null) {
            traverse(root.right);
        }
        current.remove(current.size() - 1);
    }

    public static String toStr(List<Integer> list) {
        return list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining("->"));
    }
}