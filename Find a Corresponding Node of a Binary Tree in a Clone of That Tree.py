from queue import Queue

class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        q = Queue()
        q.put(cloned)
        while not q.empty():
            if cloned.val == target.val:
                return cloned
            
            if cloned.left:
                q.put(cloned.left)
            if cloned.right:
                q.put(cloned.right)
            cloned = q.get()
        return None
    