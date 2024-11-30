/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        int pathsFromRoot = countPathsFromNode(root, targetSum, 0);
        int pathsInLeftSubtree = pathSum(root.left, targetSum);
        int pathsInRightSubtree = pathSum(root.right, targetSum);

        return pathsFromRoot + pathsInLeftSubtree + pathsInRightSubtree;
    }

    private int countPathsFromNode(TreeNode node, int targetSum, long currentSum) {
        if (node == null)
            return 0;

        currentSum += node.val;

        int pathCount = (currentSum == targetSum) ? 1 : 0;
        pathCount += countPathsFromNode(node.left, targetSum, currentSum);
        pathCount += countPathsFromNode(node.right, targetSum, currentSum);

        return pathCount;
    }
}
