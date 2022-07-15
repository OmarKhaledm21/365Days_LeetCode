/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> nodes = new ArrayList<>();
    public boolean isValidBST(TreeNode root){
        inOrder(root);
        return isSorted(nodes);
    }
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            nodes.add(root.val);
            inOrder(root.right);
        }
    }
    private boolean isSorted(ArrayList<Integer> list){
        int prev = -1;
        for(int i=0; i<list.size(); i++){
            if(i==0) prev = list.get(i);
            else if(list.get(i) <= prev) return false;
            else prev = list.get(i);
        }
        return true;
    }
}