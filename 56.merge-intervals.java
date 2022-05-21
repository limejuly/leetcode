/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<int[]>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] is : intervals) {
            System.out.println(Arrays.toString(is));
        }

        for (int i = 0; i < intervals.length;) {
            // find the first not overlapping j
            int[] current = Arrays.copyOf(intervals[i], 2);
            int j = i;
            for (; j < intervals.length && current[1] >= intervals[j][0]; j++) {
                current[1] = Math.max(current[1], intervals[j][1]);
            }

            // merge the overlapping intervals
            result.add(current);
            i = j;
        }

        return result.toArray(new int[0][]);
    }
}
// @lc code=end
