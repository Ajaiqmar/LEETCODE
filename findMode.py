class Solution:
    def __init__(self):
        self.dict = {}
        self.ma = 0
    
    def inorderTraversal(self,root):
        if(root != None):
            if root.val not in self.dict:
                self.dict[root.val] = 1
            else:
                self.dict[root.val] += 1
            
            if(self.dict[root.val] > self.ma):
                self.ma = self.dict[root.val]
            
            self.inorderTraversal(root.left)
            self.inorderTraversal(root.right)

    def findMode(self, root: TreeNode) -> List[int]:
        self.inorderTraversal(root)
        
        if(self.ma == 0):
            return []
        else:
            return [i for i in self.dict if(self.dict[i] == self.ma)]
