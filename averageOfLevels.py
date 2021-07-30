# THE PROBLEM STATEMENT IS TO FIND THE AVERAGE OF ALL THE VALUES IN EACH LEVEL OF A BINARY TREE AND RETURN IT IN THE FORM OF AN ARRAY.

# MY APPROACH IS TO DO AN DFS TRAVERSAL AND INCREMENT THE LEVEL VARIABLE FOR THE NEXT CONSECUTIVE RECURSION AND ADD THE VALUE OF THE NODE AND
# INCREMENT THE COUNT OF NODE WITH LEVEL AS INDEX VALUE IN THE COUNTOFNODES ARRAY AND SUMOFNODES ARRAY.(PS : COUNTOFNODES AND SUMOFNODES
# IS INITIALISED AS A STATIC VARIABLE.)

# ANOTHER APPROACH IS TO SOLVE IT USING A BFS APPROACH WITH THE HELP OF QUEUE DATA STRUCTURE. IN THIS APPROACH, THE ROOT IS INSERTED INITIALLY ONTO THE
# QUEUE, THEN WE START DEQUEUING THE ELEMENTS FROM THE QUEUE WHILE DOING THAT WE INSERT THE LEFT AND THE RIGHT CHILD OF THE NODE INTO A 
# TEMPORARY QUEUE AND INSERT IT INTO THE MAIN QUEUE LATER ON. THIS IS REPEATED UNTIL THE MAIN QUEUE IS EMPTY.

class Solution:
    countOfNodes = []
    sumOfNodes = []
    
    # DFS TRAVERSAL ( PRE-ORDER TRAVERSAL)
    def preorder(self,root,level):
        if(root!=None):
            if(len(Solution.sumOfNodes) == level):
                Solution.sumOfNodes.append(root.val)
                Solution.countOfNodes.append(1)
            else:
                Solution.sumOfNodes[level] += root.val
                Solution.countOfNodes[level] += 1
            self.preorder(root.left,level+1)
            self.preorder(root.right,level+1)
    
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        Solution.countOfNodes.clear()
        Solution.sumOfNodes.clear()
        
        self.preorder(root,0);
        
        # FINDING THE AVERAGE AT EACH LEVEL OF THE BINARY TREE.
        for i in range(len(Solution.sumOfNodes)):
            Solution.sumOfNodes[i] /= Solution.countOfNodes[i]
        
        return Solution.sumOfNodes

# TIME COMPLEXITY : O(N) WHERE N BEING THE NUMBER NODES IN THE BINARY TREE.
# SPACE COMPLEXITY : O(N)
