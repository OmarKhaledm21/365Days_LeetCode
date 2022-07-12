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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root != null) {
            int total = 0;
            if(root.val >= low && root.val <=high) {
                total+= root.val;
            }
            if(root.left!= null){
                total+= rangeSumBST(root.left,low,high);
            }
            if(root.right!= null){
                total+= rangeSumBST(root.right,low,high);
            }
            return total;
        }
        return 0;
    }
}