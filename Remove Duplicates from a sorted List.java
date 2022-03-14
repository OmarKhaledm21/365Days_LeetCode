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
     public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }

        ListNode start = head;
        ListNode prev = head;
        head = head.next;

        while (head!=null){
            if(head.val == prev.val){
                prev.next = head.next;
                head = prev.next;
            }else{
                prev = head;
                head = prev.next;
            }
        }
        return start;
    }
}