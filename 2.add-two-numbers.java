/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode head = res;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int tempSum = carry;
            if (l1 != null) {
                tempSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tempSum += l2.val;
                l2 = l2.next;
            }
            ListNode current = new ListNode(tempSum % 10);
            carry = tempSum / 10;
            res.next = current;
            res = res.next;
        }
        if (carry != 0) {
            ListNode current = new ListNode(carry);
            res.next = current;
        }
        return head.next;
    }
}
// @lc code=end
