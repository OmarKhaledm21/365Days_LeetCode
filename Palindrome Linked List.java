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
    public boolean isPalindrome(ListNode head) {
        StringBuilder concat = new StringBuilder();
        while (head != null) {
            concat.append(head.val);
            head = head.next;
        }
        String resulted = concat.toString();

        int len = resulted.length();
        int j = len - 1;
        int i = 0;
        while (i != j && i<len) {
            if(resulted.charAt(i) == resulted.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}