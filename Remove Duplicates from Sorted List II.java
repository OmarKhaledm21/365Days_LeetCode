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
   public ListNode deleteDuplicates(ListNode head) {
		LinkedHashSet<Integer> set = new LinkedHashSet();
		Set<Integer> duplicates = new HashSet();
		ListNode current = head;
		while (current != null) {
			if (set.contains(current.val)) {
				set.remove(current.val);
				duplicates.add(current.val);
			} else if (!duplicates.contains(current.val)) {
				set.add(current.val);
			}
			current = current.next;
		}
		duplicates.clear();

		ListNode newListHead = null, prev = null;

		for (var c : set) {
			current = new ListNode(c);
			if (prev == null) {
				newListHead = current;
				prev = current;
			} else {
				prev.next = current;
				prev = current;
			}
		}
		set.clear();
		return newListHead;
	}
}
