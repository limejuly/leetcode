import java.util.Random;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k);
    }

    // hi inclusive
    public int findKthSmallest(int[] nums, int left, int right, int k) {
        int q = partition(nums, left, right);
        if (q == k) {
            return nums[q];
        } else if (q <= k) {
            return findKthSmallest(nums, q + 1, right, k);
        } else {
            return findKthSmallest(nums, left, q - 1, k);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pi = new Random().nextInt(right - left + 1) + left;
        int pivot = nums[pi];
        swap(nums, pi, right);

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end