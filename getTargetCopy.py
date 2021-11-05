# THE PROBLEM STATEMENT IS TO GET THE TARGET VALUE EQUIVALENT IN THE CLONED BINARY TREE USING THE ORIGINAL TREE. THE CLONED BINARY TREE IS A CLONE
# OF THE ORIGINAL TREE.

# MY APPROACH IS TO DO A DFS TRAVERSAL AND LOCATE THE TARGET POINTER IN THE ORIGINAL TREE, THEN RETURN THE CLONED TREE EQUIVALENT OF IT.

class Solution:
    # TRAVERSING THE BINARY TREE STRUCTURE. 
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        
        if(original != None):
            
            if(original == target):
                return cloned
            
            l = self.getTargetCopy(original.left,cloned.left,target)
            r = self.getTargetCopy(original.right,cloned.right,target)
            
            if(l != None):
                return l
            
            if(r != None):
                return r
        
        return None
      
# TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES IN THE BINARY TREE.
# SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE BINARY TREE.
