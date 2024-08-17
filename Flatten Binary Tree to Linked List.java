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
    	public void flatten(TreeNode root) {
		List<TreeNode> list = new LinkedList<TreeNode>();
		flatten(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			TreeNode n = list.get(i);
			n.left = null;
			if(i+1 == list.size()) {
				n.right = null;
			}else {
				n.right = list.get(i+1);
			}
		}
	}

	public void flatten(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			return;
		}
		list.add(root);
		flatten(root.left,list);
		flatten(root.right,list);
	}
}
