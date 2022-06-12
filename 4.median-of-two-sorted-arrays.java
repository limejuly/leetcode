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
        int l = nums1.length + nums2.length;
        if (l % 2 == 0) {
            return (findKthSmallest(nums1, nums2, l / 2) + findKthSmallest(nums1, nums2, l / 2 + 1)) * 0.5;
        } else {
            return findKthSmallest(nums1, nums2, l / 2 + 1);
        }
    }

    public int findKthSmallest(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int start1 = 0, start2 = 0;
        while (true) {
            if (start1 == len1) { // nums1 is all excluded, so find from nums2
                return nums2[start2 + k - 1];
            }
            if (start2 == len2) { // nums2 is all excluded
                return nums1[start1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }
            int half = k / 2;
            int index1 = Math.min(start1 + half - 1, nums1.length - 1);
            int index2 = Math.min(start2 + half - 1, nums2.length - 1);

            if (nums1[index1] <= nums2[index2]) {
                k -= (index1 - start1 + 1);
                start1 = index1 + 1;
            } else {
                k -= (index2 - start2 + 1);
                start2 = index2 + 1;
            }
        }
    }
}

// @lc code=end
class Solution2 {
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
