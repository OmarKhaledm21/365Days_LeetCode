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
class Solution {
		public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode curr = head;

		ListNode oddNode = null;
		ListNode evenNode = null;
		ListNode evenHead = null;

		int i = 1;
		int j = 0;
		int k = 0;
		while (curr != null) {
			if (i % 2 == 1) {
				if (oddNode == null) {
					oddNode = curr;
				} else {

					oddNode.next = curr;
					oddNode = curr;
				}
				j++;
			} else {
				if (evenNode == null) {
					evenNode = curr;
					evenHead = evenNode;
				} else {
					evenNode.next = curr;
					evenNode = curr;
				}

				k++;
			}
			i++;
			curr = curr.next;
		}

		oddNode.next = evenHead;
		evenNode.next = null;
		return head;

	}
}
