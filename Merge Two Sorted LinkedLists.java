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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if(list1 == null && list2 == null){
            return null;
        }
        ListNode res = new ListNode();
        ListNode resHead = res;
        while (list1 != null && list2 !=null){
            if(list1.val <= list2.val){
                res.val = list1.val;
                list1 = list1.next;
            }else{
                res.val = list2.val;
                list2 = list2.next;
            }
            res.next = new ListNode();
            res = res.next;
        }

        ListNode prev = null;
        while (list1 != null){
            res.val = list1.val;
            list1 = list1.next;
            prev = res;
            res.next = new ListNode();
            res= res.next;
        }

        while (list2 != null){
            res.val = list2.val;
            list2 = list2.next;
            prev = res;
            res.next = new ListNode();
            res= res.next;
        }
        prev.next = null;
        return resHead;
    }
}