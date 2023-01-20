# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def evaluateTree(self, root: Optional[TreeNode]) -> bool:
        if root:
            if root.val == 0 or root.val == 1:
                return root.val

            a = self.evaluateTree(root.left)
            if root.val == 2:
                if a == 1:
                    return a
                return self.evaluateTree(root.right)
            if root.val == 3:
                if a == 0:
                    return a
                return self.evaluateTree(root.right)