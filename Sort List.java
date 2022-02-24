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
import java.util.ArrayList;
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head!=null){
            nodes.add(head);
            head = head.next;
        }
        
        quickSortMiddlePivot(nodes,0,nodes.size()-1);

        for (int i =0; i<nodes.size(); i++) {
            if(i+1 != nodes.size()) {
                nodes.get(i).next = nodes.get(i + 1);
            }else{
                nodes.get(i).next = null;
            }
        }

        return nodes.get(0);
    }

    static int partitionMiddle(ArrayList<ListNode> arr,int l,int r,int pivot) {
        while (l <= r) {
            while (arr.get(l).val < pivot) {
                l++;
            }

            while (arr.get(r).val > pivot) {
                r--;
            }


            if (l <= r) {
                int temp = arr.get(l).val;
                arr.get(l).val=arr.get(r).val;
                arr.get(r).val=temp;
                l++;
                r--;
            }
        }
        return l;
    }

    static void quickSortMiddlePivot(ArrayList<ListNode> arr,int l,int r) {
        if (l < r) {
            int pivot = arr.get( (l+r) / 2).val;

            int pivotInRightPlaceIndex = partitionMiddle(arr,l,r,pivot);

            quickSortMiddlePivot(arr, l, pivotInRightPlaceIndex - 1);
            quickSortMiddlePivot(arr, pivotInRightPlaceIndex, r);
        }
    }
}