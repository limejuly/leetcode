import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> nums3 = new ArrayList<Integer>(nums1.length + nums2.length);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums3.add(nums1[i++]);
            } else {
                nums3.add(nums2[j++]);
            }
        }
        while (i < nums1.length) {
            nums3.add(nums1[i++]);
        }
        while (j < nums2.length) {
            nums3.add(nums2[j++]);
        }
        int mid = (nums1.length + nums2.length) / 2;
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (nums3.get(mid - 1) + nums3.get(mid)) / 2.0;
        } else {
            return nums3.get(mid) / 1.0;
        }
    }
}

// @lc code=end
