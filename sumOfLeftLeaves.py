class Solution:
    def __init__(self):
        self.ans = 0
        
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if(root!=None):
            if(root.left != None and root.left.left == None and root.left.right == None):
                self.ans += root.left.val
            self.sumOfLeftLeaves(root.left)
            self.sumOfLeftLeaves(root.right)
        
        return self.ans
