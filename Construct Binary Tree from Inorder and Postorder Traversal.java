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
    	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	}

	public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
			Map<Integer, Integer> map) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}
		int rootVal = postorder[postEnd];
		TreeNode root = new TreeNode(rootVal);

		int rootIndex = map.get(rootVal);

		int leftSize = rootIndex - inStart;
		int rightSize = inEnd - rootIndex;
		
		root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1, map);
		root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1, map);

		return root;
	}
}
