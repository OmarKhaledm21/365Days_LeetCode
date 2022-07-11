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
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        TreeNode treeNode = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
//        solution.preorderTraversal(treeNode);
//        System.out.println(solution.list);
//
//    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root!=null){
            list.add(root.val);
            list.addAll(preorderTraversal(root.left));
            list.addAll(preorderTraversal(root.right));
        }
        return list;
    }
}