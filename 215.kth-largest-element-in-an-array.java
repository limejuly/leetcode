import java.util.Random;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    // k starts from 1
    public int findKthLargest(int[] nums, int k) {
        return qSelect(nums, 0, nums.length, nums.length - k);
    }

    // k starts from 0, right exclusive
    public int qSelect(int[] nums, int left, int right, int k) {
        int p = partition(nums, left, right);
        if (p == k) {
            return nums[k];
        } else if (p < k) {
            return qSelect(nums, p + 1, right, k);
        } else {
            return qSelect(nums, left, p, k);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pi = new Random().nextInt(right - left) + left;
        int pivot = nums[pi];
        swap(nums, pi, right - 1);

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right - 1);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
