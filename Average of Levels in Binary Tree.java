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
    class Pair {
        TreeNode node;
        int lvl;

        public Pair(TreeNode node, int lvl) {
            this.node = node;
            this.lvl = lvl;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Pair> list = new ArrayList();
        Queue<Pair> queue = new LinkedList();
        int currLvl = 0;
        Pair p = new Pair(root, currLvl);
        queue.add(p);
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            list.add(curr);
            TreeNode currNode = curr.node;
            currLvl = curr.lvl;

            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, currLvl + 1));
            }
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, currLvl + 1));
            }

        }

        List<Double> averages = new ArrayList();

        double sum = 0.0;
        int counter = 0;
        currLvl = 0;
        for (int i = 0; i < list.size(); i++) {
            Pair curr = list.get(i);
            if (curr.lvl != currLvl) {
                averages.add(sum / counter);
                sum = 0.0;
                counter = 0;
                currLvl = curr.lvl;
            }
            counter++;
            sum += curr.node.val;
        }
        averages.add(sum / counter);

        return averages;

    }
}
