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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList();
		if (root == null) {
			return list;
		}
		Queue<Pair> queue = new LinkedList<Pair>();
		int currLvl = 0;
		Pair p = new Pair(root, currLvl);
		queue.add(p);
		while (!queue.isEmpty()) {
			Pair curr = queue.poll();
			TreeNode currNode = curr.node;
			currLvl = curr.lvl;

			if (list.size() <= currLvl) {
				list.add(new ArrayList<Integer>());
			}
			list.get(currLvl).add(currNode.val);

			if (currNode.left != null) {
				queue.add(new Pair(currNode.left, currLvl + 1));
			}
			if (currNode.right != null) {
				queue.add(new Pair(currNode.right, currLvl + 1));
			}

		}

		boolean rev = false;
		for (List<Integer> l : list) {
			if (rev) {
				Collections.reverse(l);
			}
			rev = !rev;
		}

		return list;
	}

	class Pair {
		TreeNode node;
		int lvl;

		public Pair(TreeNode node, int lvl) {
			this.node = node;
			this.lvl = lvl;
		}
	}

}
