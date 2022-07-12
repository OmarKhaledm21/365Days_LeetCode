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
    public int minDepth(TreeNode root) {
        int minDepth = Integer.MAX_VALUE;
        int currentDepth=0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return 0;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode current = queue.poll();
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
                if(current.left == null && current.right==null){
                    minDepth = Math.min(currentDepth+1,minDepth);
                }
            }
            currentDepth++;
        }
        return minDepth;
    }
}/**
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
    public int minDepth(TreeNode root) {
        int minDepth = Integer.MAX_VALUE;
        int currentDepth=0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return 0;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode current = queue.poll();
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
                if(current.left == null && current.right==null){
                    minDepth = Math.min(currentDepth+1,minDepth);
                }
            }
            currentDepth++;
        }
        return minDepth;
    }
}