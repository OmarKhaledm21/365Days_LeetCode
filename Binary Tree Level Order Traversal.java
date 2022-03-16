import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        new Solution().levelOrder(treeNode);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> parent = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> child;
        if (root == null) {
            return parent;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            child = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                child.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            parent.add(child);
        }
        return parent;
    }
}

