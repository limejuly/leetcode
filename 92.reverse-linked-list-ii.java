/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode revTail = pre.next;
        ListNode newHead = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode cur = pre.next;
            pre.next = pre.next.next;
            cur.next = newHead;
            newHead = cur;
        }

        revTail.next = pre.next;
        pre.next = newHead;
        return dummy.next;
    }
}
// @lc code=end
