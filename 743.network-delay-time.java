import java.util.*;

/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> adj = new HashMap<>();

        for (int[] time : times) {
            int from = time[0] - 1;
            int to = time[1] - 1;
            int weight = time[2];
            adj.putIfAbsent(from, new ArrayList<>());
            adj.get(from).add(new Edge(to, weight));
        }

        int[] distance = dijkstra(adj, n, k - 1);
        int max = 0;
        for (int d : distance) {
            if (d == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, d);
        }
        return max;
    }

    public int[] dijkstra(Map<Integer, List<Edge>> adj, int n, int k) {
        int[] distanceTo = new int[n];
        Arrays.fill(distanceTo, Integer.MAX_VALUE);
        distanceTo[k] = 0;

        PriorityQueue<Node> qp = new PriorityQueue<>();
        qp.offer(new Node(k, distanceTo[k]));

        while (!qp.isEmpty()) {
            Node from = qp.poll();
            if (!adj.containsKey(from.index)) {
                continue;
            }
            for (Edge e : adj.get(from.index)) {
                int weight = e.weight;
                int to = e.index;
                int distance = distanceTo[from.index] + weight;
                if (distance < distanceTo[to]) {
                    distanceTo[to] = distance;
                    qp.offer(new Node(to, distance));
                }
            }
        }

        return distanceTo;
    }

    class Edge {
        int index;
        int weight;

        public Edge(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    class Node implements Comparable<Node> {
        int index;
        int distanceTo;

        public Node(int index, int distance) {
            this.index = index;
            this.distanceTo = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distanceTo - o.distanceTo;
        }
    }
}
// @lc code=end
