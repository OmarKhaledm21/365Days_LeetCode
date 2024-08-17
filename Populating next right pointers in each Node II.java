/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
   	class Pair {
		Node node;
		int lvl;

		public Pair(Node node, int lvl) {
			this.node = node;
			this.lvl = lvl;
		}
	}

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		ArrayList<Pair> pairs = new ArrayList();
		Queue<Pair> queue = new LinkedList();
		int i = 1;
		queue.add(new Pair(root, i));
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int curr = p.lvl + 1;
			pairs.add(p);
			if (p.node.left != null) {
				queue.add(new Pair(p.node.left, curr));
			}
			if (p.node.right != null) {
				queue.add(new Pair(p.node.right, curr));
			}
		}
		Node prev = null;
		int currLvl = -1;
		for(Pair x : pairs) {
			if(x.lvl == 1) {
				continue;
			}
			if(prev == null) {
				currLvl = x.lvl;
				prev = x.node;
				continue;
			}
			if(currLvl < x.lvl) {
				currLvl = x.lvl;
				prev = x.node;
			}else {
				prev.next = x.node;	
                prev = x.node;
			}
			
		}

		return root;
	}

}
