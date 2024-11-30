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
	public int goodNodes(TreeNode root) {
		if (root.left == null && root.right == null) {
			return 1;
		}
		return goodNodes(root.left, root.val) + goodNodes(root.right, root.val) + 1;
	}

	public int goodNodes(TreeNode root, int x) {
		if (root == null) {
			return 0;
		}
		int res = 0;

		if (root.val >= x) {
			x = root.val;
			res++;
		}

		res += goodNodes(root.left, x);
		res += goodNodes(root.right, x);

		return res;
	}
}
