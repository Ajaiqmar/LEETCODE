class Solution:
    minDiff = 0
    
    def inorder(self,root,elements):
        if(root != None):
            self.inorder(root.left,elements)
            if(len(elements) > 0):
                if((root.val-elements[-1]) < Solution.minDiff):
                    Solution.minDiff = root.val-elements[-1]
            elements.append(root.val)
            print(elements)
            self.inorder(root.right,elements)
    
    def minDiffInBST(self, root: TreeNode) -> int:
        Solution.minDiff = sys.maxsize
        self.inorder(root,[])
        return Solution.minDiff
