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
   public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		int target = count - n + 1;
		
		if(target==1) {
			head = head.next;
			return head;
		}
		
		current = head;
		int currInd = 0;
		while(current!=null) {
			currInd++;
			if(currInd == target-1) {
				current.next = current.next.next;
				break;
			}
			current = current.next;
		}
		return head;
	}

}
