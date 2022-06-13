
/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution0 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // i, j belong to second part
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;// +1 to combine odd and even

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1],
            // nums2[j]
            // 当一个数组不出现在前一部分时,对应的值为负无穷,就不会对前一部分的最大值产生影响
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            // 当一个数组不出现在后一部分时,对应的值为正无穷,就不会对后一部分的最小值产生影响
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}

class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        if (l % 2 == 0) {
            return (findKthSmallest(nums1, nums2, l / 2 - 1) + findKthSmallest(nums1, nums2, l / 2)) * 0.5;
        } else {
            return findKthSmallest(nums1, nums2, l / 2);
        }
    }

    public int findKthSmallest(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 特殊情况
            if (index1 == length1) { // 第二种特殊情况,一个数组为空
                return nums2[index2 + k];
            }
            if (index2 == length2) { // 第二种特殊情况,一个数组为空
                return nums1[index1 + k];
            }
            if (k == 1) { // 第三种特殊情况,k=1
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况,index1,index2作为起始点,newindex1,newindex2作为比较点 在不停的更新
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1; // 第一种特殊情况,发生越界,记录需要比较的位置
            int newIndex2 = Math.min(index2 + half, length2) - 1; // 第一种特殊情况,发生越界,记录需要比较的位置
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2]; // 获取两个需要比较的数
            if (pivot1 <= pivot2) { // <=将两种情况合并
                k -= (newIndex1 - index1 + 1); // 两者相减后+1,这才是真正减去的长度
                index1 = newIndex1 + 1; // 连同比较位置也一同删去了,所以新的开始是 比较位置 的后一位
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}

class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right; // 每次循环前将 right 的值赋给 left
            // A移动的条件: B遍历到最后 或 当前A<B,满足一个即可
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0) // 与1交,判断奇偶数,更快速
            return (left + right) / 2.0;
        else
            return right;
    }
}
// @lc code=end
