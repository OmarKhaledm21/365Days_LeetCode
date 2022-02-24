import java.util.Hashtable;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }else if(head.next == null){
            return false;
        }
        Hashtable<ListNode,Integer>  list = new Hashtable<>();
        int ind =0;
        while (head.next != null){
            list.put(head,ind);
            ind++;
            if(list.containsKey(head.next)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}