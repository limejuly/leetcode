import java.util.*;
/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            current.next = min;
            current = current.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        return dummy.next;
    }

}
// @lc code=end
