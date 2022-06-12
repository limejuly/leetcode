import java.util.Random;

/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        qSort(nums, 0, nums.length);
        return nums;
    }

    public void qSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right);
        qSort(nums, left, p);
        qSort(nums, p + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int p = new Random().nextInt(right - left) + left;
        int pivot = nums[p];
        swap(nums, p, right - 1);

        int i = left - 1;
        for (int j = left; j < right - 1; j++) {
            if (nums[j] <= pivot) {
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
