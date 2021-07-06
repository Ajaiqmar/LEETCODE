class Solution:
    countOfNodes = []
    sumOfNodes = []
    
    def inorder(self,root,level):
        if(root!=None):
            if(len(Solution.sumOfNodes) == level):
                Solution.sumOfNodes.append(root.val)
                Solution.countOfNodes.append(1)
            else:
                Solution.sumOfNodes[level] += root.val
                Solution.countOfNodes[level] += 1
            self.inorder(root.left,level+1)
            self.inorder(root.right,level+1)
    
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        Solution.countOfNodes.clear()
        Solution.sumOfNodes.clear()
        
        self.inorder(root,0);
        
        for i in range(len(Solution.sumOfNodes)):
            Solution.sumOfNodes[i] /= Solution.countOfNodes[i]
        
        return Solution.sumOfNodes
