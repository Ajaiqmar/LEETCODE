class Solution:
    def checkEquality(self,root,subRoot):
        if(root == None and subRoot == None):
            return True
        elif(root!=None and subRoot!=None):
            if(root.val == subRoot.val):
                return self.checkEquality(root.left,subRoot.left) and self.checkEquality(root.right,subRoot.right)
        return False
        
    def isSubtree(self, root: TreeNode, subRoot: TreeNode) -> bool:
        if(root!=None):
            if(root.val == subRoot.val):
                if(self.checkEquality(root,subRoot)):
                    return True
            return self.isSubtree(root.left,subRoot) or self.isSubtree(root.right,subRoot)
        return False
