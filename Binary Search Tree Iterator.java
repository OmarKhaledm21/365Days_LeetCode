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
class BSTIterator {
	private ArrayList<Integer> nums;
	private int nextInd;

	public BSTIterator(TreeNode root) {
		nextInd = 0;
		nums = new ArrayList();
		nums.add(-1);
		inorderInit(root);
	}

	public int next() {
		this.nextInd++;
		return this.nums.get(nextInd);
	}

	public boolean hasNext() {
		return (nextInd < nums.size() - 1);
	}

	public void inorderInit(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderInit(root.left);
		nums.add(root.val);
		inorderInit(root.right);
	}
}


