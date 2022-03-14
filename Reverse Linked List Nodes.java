import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution solution = new Solution();
        solution.reverseList(n1);
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pointer = head;
        Stack<Integer> stack = new Stack<>();
        while(pointer != null){
            stack.push(pointer.val);
            pointer = pointer.next;
        }

        ListNode tail = new ListNode(stack.pop());
        pointer = tail;
        while(!stack.isEmpty()){
            ListNode temp = new ListNode(stack.pop());
            pointer.next = temp;
            pointer = temp;
        }
        return tail;
    }
}