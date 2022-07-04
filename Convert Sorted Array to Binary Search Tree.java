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
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        return sortedArrayToBSTUtil(nums, 0, len - 1);
    }

    public TreeNode sortedArrayToBSTUtil(int[] nums, int l, int h) {
        if (l > h) return null;
        
        int mid = (l + h) / 2;
        
        TreeNode leftChild = sortedArrayToBSTUtil(nums,l,mid -1);
        TreeNode rightChild = sortedArrayToBSTUtil(nums,mid+1,h);
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}