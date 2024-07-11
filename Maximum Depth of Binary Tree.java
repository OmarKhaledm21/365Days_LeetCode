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
 public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		}
		int depth = 1;
		Stack<Object[]> stack = new Stack();
		stack.push(new Object[] { root, 1 });
		while (!stack.isEmpty()) {
			Object[] obj = stack.pop();
			TreeNode node = (TreeNode) obj[0];
			int level = (int) obj[1];
			if (node.left != null) {
				stack.push(new Object[] { node.left, level + 1 });
			}
			if (node.right != null) {
				stack.push(new Object[] { node.right, level + 1 });
			}
			depth = Math.max(depth, level);
		}

		return depth;
	}
}
