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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode current = head;
        while (current.next != null) {
            len++;
            current = current.next;
        }
        current.next = head;
        int rotations = len - k % len;
        for (int i = 0; i < rotations; i++) {
            current = current.next;
        }

        ListNode newHead = current.next;
        current.next = null;

        return newHead;
    }
}
