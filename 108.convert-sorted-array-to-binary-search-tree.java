/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length/2;
        TreeNode node = new TreeNode(nums[mid]);
        if (mid>0){
            node.left = sortedArrayToBST(sub(nums,0,mid));
        }
        if (mid+1<nums.length){
            node.right = sortedArrayToBST(sub(nums,mid+1, nums.length));
        }
        return node;
    }
    private int[] sub(int[] nums, int left, int right){
        return Arrays.copyOfRange(nums,left,right);
    }
}
// @lc code=end

