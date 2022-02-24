/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.Hashtable;
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         Hashtable<ListNode,Integer> hashtable = new Hashtable<>();
        if(headA == null || headB == null){
            return null;
        }

        while (headA!=null){
            hashtable.put(headA,999_999);
            headA = headA.next;
        }
        while (headB!= null){
            if( hashtable.containsKey(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}