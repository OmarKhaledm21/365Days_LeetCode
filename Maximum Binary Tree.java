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
    public  TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public  TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (nums.length == 0) {
            return null;
        }

        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(nums, l, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, r);
        return root;
    }
}