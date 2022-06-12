import java.util.Arrays;
import java.util.Random;

/*
* 经典的 shuffle 算法  Fisher-Yates algorithm: 
* 从后到前(反之亦然)遍历数组, 对每个 item, 产生一个[0-i]随机数,与它交换位置. 重要的是: 要包括它自己. 不然某些排列出现的概率会更高.
* 算法模拟的是暴力算法: 把数都放到以堆, 每次随机从中抽取一个, 剩下的数组 shrink, 这样最终结果就是随机的. FY 算法只是用交换代替数组 remove, 节约shrink 的时间.
# 
*/

/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 */

// @lc code=start
class Solution {
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(nums, nums.length);
        for (int i = nums.length - 1; i > 0; i--) {
            // back to force, swap item with random element in front or itself(itself is
            // important)
            int rand = new Random().nextInt(i + 1);
            swap(shuffled, rand, i);
        }
        return shuffled;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end
