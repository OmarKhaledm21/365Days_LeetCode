# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    root = None
    def increasingBST(self, root: TreeNode) -> TreeNode:
        if root:
            if root.left:
                self.increasingBST(root.left)
            
            if self.root== None:
                self.root = TreeNode(root.val)
                self.current = self.root
            else:
                right_node = TreeNode(root.val)
                self.current.right = right_node
                self.current = right_node
            if root.right:
                self.increasingBST(root.right)
        return self.root