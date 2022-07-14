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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        TreeNode current = root,prev = root;
        while (current!= null){
            if(current.val > val){
                prev = current;
                current = current.left;
            }else if(current.val < val){
                prev = current;
                current = current.right;
            }
        }
        if(prev.val > val){
            prev.left = new TreeNode(val);
        }else{
            prev.right = new TreeNode(val);
        }
        return root;
    }
}