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
 import java.math.BigInteger;
class Solution {
    
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		BigInteger num1 = new BigInteger("0");
		BigInteger num2 = new BigInteger("0");
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		while (l1 != null) {
			sb1.append(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			sb2.append(l2.val);
			l2 = l2.next;
		}

		String n1;
		String n2;

		n1 = sb1.reverse().toString();
		n2 = sb2.reverse().toString();

		num1 = new BigInteger(n1);
		num2 = new BigInteger(n2);
		BigInteger sum = num1.add(num2);

		String sumStr = sum.toString();

		ListNode head = new ListNode(Character.getNumericValue(sumStr.charAt(sumStr.length() - 1)));
		ListNode current = head;

		for (int i = sumStr.length() - 2; i >= 0; i--) {
			current.next = new ListNode(Character.getNumericValue(sumStr.charAt(i)));
			current = current.next;
		}
		return head;
	}

}
