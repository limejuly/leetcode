import java.util.Arrays;

/*
 * @lc app=leetcode id=1889 lang=java
 *
 * [1889] Minimum Space Wasted From Packaging
 */

// @lc code=start
class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int plen = packages.length;
        long minWaste = Integer.MAX_VALUE;
        long pSum = 0;
        for (int i = 0; i < packages.length; i++) {
            pSum += packages[i];
        }

        for (int j = 0; j < boxes.length; j++) {
            int[] group = boxes[j];
            Arrays.sort(group);
            int glen = group.length;
            // can't fit in
            if (packages[plen - 1] > group[glen - 1]) {
                continue;
            }
            long used = 0;
            int last = -1;
            int firstBox = searchLarger(group, packages[0], 0, glen - 1);
            for (int i = firstBox; i < group.length; i++) {
                int current = searchSmaller(packages, group[i], last + 1, plen - 1);
                if (j == 0) {
                    System.out.println(current);
                }
                if (current > 0) {
                    used += (current - last) * group[i];
                    last = current;
                }
            }
            long waste = used - pSum;
            minWaste = Math.min(minWaste, waste);
        }
        long res = (minWaste == Integer.MAX_VALUE) ? -1 : minWaste;
        return (int) res % (1000000000 + 7);
    }

    // find largest nums[k] <= p
    public int searchSmaller(int[] nums, int p, int left, int right) {
        int res = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > p) {
                right = mid - 1;
            } else if (nums[mid] <= p) {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }

    // find smallest nums[k] >= p
    public int searchLarger(int[] nums, int p, int left, int right) {
        int res = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= p) {
                res = mid;
                right = mid - 1;
            } else if (nums[mid] < p) {
                left = mid + 1;
            }
        }
        return res;
    }

}
// @lc code=end
