/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Pair pair = new Pair(0, root);
        Queue<Pair> queue = new LinkedList();
        queue.add(pair);
        List<Integer> list = new ArrayList();
        while (!queue.isEmpty()) {
            pair = queue.poll();
            if (list.size() <= pair.lvl) {
                list.add(pair.node.val);
            } else {
                int currVal = list.get(pair.lvl) + pair.node.val;
                list.set(pair.lvl, currVal);
            }
            if (pair.node.left != null) {
                Pair l = new Pair(pair.lvl + 1, pair.node.left);
                queue.add(l);
            }
            if (pair.node.right != null) {
                Pair r = new Pair(pair.lvl + 1, pair.node.right);
                queue.add(r);
            }
        }
        int max = Integer.MIN_VALUE;
        int lvl = -1;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num > max) {
                lvl = i;
                max = num;
            }
        }
        return lvl + 1;

    }

    class Pair {
        private int lvl;
        private TreeNode node;

        public Pair(int lvl, TreeNode node) {
            this.lvl = lvl;
            this.node = node;
        }

        public int getLvl() {
            return lvl;
        }

        public void setLvl(int lvl) {
            this.lvl = lvl;
        }

        public TreeNode getVal() {
            return node;
        }

        public void setVal(TreeNode node) {
            this.node = node;
        }

    }
}
