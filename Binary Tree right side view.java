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
    
		public List<Integer> rightSideView(TreeNode root) {
		List<List<Integer>> list = new ArrayList();
		if (root == null) {
			return new ArrayList();
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

		List<Integer> res = new ArrayList();
		
		for(List<Integer> l : list) {
			res.add(l.get(l.size()-1));
		}
		
		return res;
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