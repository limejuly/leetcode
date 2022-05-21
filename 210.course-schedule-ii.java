import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> que = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            if (graph[from][to] == 0) {
                indegree[to]++;
            }
            graph[from][to] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }
        while (!que.isEmpty()) {
            int cur = que.poll();
            res.add(cur);
            for (int i = 0; i < numCourses; i++) {
                if (graph[cur][i] == 1) {
                    if (--indegree[i] == 0) {
                        que.offer(i);
                    }
                }
            }
        }
        return (res.size() == numCourses) ? res.stream().mapToInt(Integer::intValue).toArray() : new int[0];

    }
}
// @lc code=end
