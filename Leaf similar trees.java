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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> seq1 = new ArrayList<Integer>();
        ArrayList<Integer> seq2 = new ArrayList<Integer>();

        getSequence(root1, seq1);
        getSequence(root2, seq2);

        if (seq1.size() != seq2.size()) {
            return false;
        }

        for (int i = 0; i < seq1.size(); i++) {
            if (!seq1.get(i).equals(seq2.get(i))) {
                return false;
            }

        }

        return true;
    }

    public void getSequence(TreeNode root, ArrayList<Integer> seq) {
        if (root.left == null && root.right == null) {
            seq.add(root.val);
            return;
        }
        if (root.left != null) {
            getSequence(root.left, seq);
        }
        if (root.right != null) {
            getSequence(root.right, seq);
        }

    }
}
