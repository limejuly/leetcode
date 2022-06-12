import java.util.*;

/*
 * @lc app=leetcode id=870 lang=java
 * 
 * [870] Advantage Shuffle
 * 
 * 原来的想法: 在 nums1 基础上做修改, i = 0...n, 每次用二分找出比 nums2 对应元素大的第一个数, move 到当前位置, 其他元素顺移. 但是顺移太耗时间了, time limit exeed. 解决办法: 不动原数组, 并用一个 visited 数组记录当前item 是否已经被选了. (但是很难, 在一个满是窟窿的数组上进行二分查找) 或者用 BST?
 * 更好的办法: greedy? 大致想法还是对每个 B 找大于它的最小数. 但是这次两个数组都排序, 找到的数用 map 存, 因此不用二分查找也不费时间.最后如果没有大于B 的数, 就把剩下的随便分.
 */

// @lc code=start
class Node {
    int index;
    int val;
    int rival;

    public Node(int index, int val, int rival) {
        this.index = index;
        this.val = val;
        this.rival = rival;
    }
}

// @lc code=start
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Node[] s2 = new Node[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            Node node = new Node(i, nums2[i], -1);
            s2[i] = node;
        }
        Arrays.sort(s2, Comparator.comparingInt(a -> a.val));
        LinkedList<Integer> remaining = new LinkedList<>();
        int[] res = new int[nums1.length];
        int j = 0;
        for (int a : nums1) {
            if (a > s2[j].val) {
                s2[j].rival = a;
                j++;
            } else {
                remaining.offer(a);
            }
        }
        for (Node b : s2) {
            if (b.rival != -1) {
                res[b.index] = b.rival;
            } else {
                res[b.index] = remaining.poll();
            }
        }
        return res;
    }
}

// @lc code=end
