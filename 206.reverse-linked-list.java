/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 * 
 */

// @lc code=start
/* iterative version */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}

/* recursive version */
class SolutionRecur {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
// @lc code=end
