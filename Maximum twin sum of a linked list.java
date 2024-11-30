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
    public int pairSum(ListNode head) {
        ListNode curr = head;
        ArrayList<Integer> list = new ArrayList();
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        int res = 0;
        for (int i = 0, j = list.size() - 1; i < list.size(); i++, j--) {
            res = Math.max(res, list.get(i) + list.get(j));
        }
        return res;
    }
}
