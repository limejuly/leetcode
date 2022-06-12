import java.util.*;

/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    private void traverse(int[][] graph, int node, LinkedList<Integer> path) {
        path.addLast(node);
        if (node == graph.length - 1) {
            res.add(new LinkedList(path));
        }
        for (int neighbor : graph[node]) {
            traverse(graph, neighbor, path);
        }
        path.removeLast();
    }
}
// @lc code=end
