class Solution:
    def sumOfNode(self,root):
        if(root!=None):
            return self.sumOfNode(root.left)+self.sumOfNode(root.right)+root.val
        return 0
    
    def findTilt(self, root: TreeNode) -> int:
        if(root!=None):
            return self.findTilt(root.left)+self.findTilt(root.right)+abs(self.sumOfNode(root.left)-self.sumOfNode(root.right))
        return 0
