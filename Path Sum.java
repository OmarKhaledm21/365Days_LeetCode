class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        int s = targetSum - root.val;
        if (s == 0 && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, s) || hasPathSum(root.right, s);
    }
}