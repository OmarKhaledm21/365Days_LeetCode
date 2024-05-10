
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);

		Solution solution = new Solution();
		System.out.println(solution.countNodes(root));
	}

	public int countNodes(TreeNode root) {
		int c = 0;

		if (root == null) {
			return c;
		}
		c++;
		c+= countNodes(root.left);
		c+= countNodes(root.right);
		
		return c;
	}
}
