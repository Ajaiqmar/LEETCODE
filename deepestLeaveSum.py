# THE PROBLEM STATEMENT IS TO FIND THE SUM OF THE VALUES OF DEEPEST LEAVES OF THE GIVEN BINARY TREE. DEEPEST LEAVES ARE THE LEAF NODES WITH LARGEST DEPTH. 
# LEAF NODES ARE THE NODES THAT HAVE NO CHILDREN NODE.

# MY APPROACH IS TO DO A DFS TRAVERSAL AND ALSO KEEP IN CHECK OF THE LEVELS OF THE NODES IN THE BINARY TREE. IF A NODES LEVEL IS GREATER THAN MAX LEVEL,
# REFRESH THE SUM AND SET THE INITIAL VALUE TO CURRENT ROOT VAL. THEN IF THE NODES LEVEL IS EQUAL TO THE MAX LEVEL, ADD THE CURRENT ROOT VAL TO 
# THE SUM.

class Solution:
    # FUNCTION TO TRAVERSE THE GIVEN BINARY TREE.
    def traversal(self,root,level):
        if(root != None):
            
            if(level > self.maxLevel):
                self.maxLevel = level
                self.sum = root.val
            
            elif(level == self.maxLevel):
                self.sum += root.val
            
            self.traversal(root.left,level+1)
            self.traversal(root.right,level+1)
            
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        self.sum = 0
        self.maxLevel = -1
        self.traversal(root,0)
        
        return self.sum
      
# TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES IN THE BINARY TREE.
# SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE BINARY TREE.
