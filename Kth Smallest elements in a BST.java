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
    public int kthSmallest(TreeNode root, int k) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		addElementsToQueue(root, queue);
		int target = -1;
		for (int i=0; i<k; i++) {
			target = queue.poll();
		}
		return target;
	}

	public void addElementsToQueue(TreeNode root, Queue<Integer> queue) {
		if (root == null) {
			return;
		}
		queue.add(root.val);
		addElementsToQueue(root.left, queue);
		addElementsToQueue(root.right, queue);
	}
}
