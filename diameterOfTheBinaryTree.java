// THE PROBLEM STATEMENT IS TO RETURN THE DIAMETER OF A BINARY TREE. THE DIAMETER OF A BINARY TREE IS THE LONGEST PATH BETWEEN TWO NODES.

// APPROACH 1 - MY APPROACH IS TO TRAVERSE THE GIVEN BINARY TREE, AND FOR EACH NODE FIND THE HEIGHT OF THE LEFT SUBTREE AND RIGHT SUBTREE USING THE LENGTH OF THE NODE FUNCTION,
// THEN CHECK IF SUM OF BOTH HEIGHTS IS THE DIAMETER OF THE GIVEN BINARY TREE.
// I BULIT THE FUNCTIONS IN SUCH A WAY THAT ALL THE ABOVE FUNCTIONS ARE CARRIED OUT RECURSIVELY.

class Solution 
{
    // FUNCTION TO FIND THE HEIGHT OF THE TREE DATA STRUCTURE.
    public int lengthOfTheNode(TreeNode root)
    {
        if(root!=null)
        {
            return 1+Math.max(this.lengthOfTheNode(root.left),this.lengthOfTheNode(root.right));
        }
        return 0;
    }
    
    // FUNCTION TO TRAVERSE THE GIVEN BINARY TREE DATA STRUCTURE AND FIND THE DIAMETER OF THE BINARY TREE.
    public int Traversal(TreeNode root)
    {
        if(root!=null)
        {
            return Math.max(this.inorderTraversal(root.left),Math.max(this.lengthOfTheNode(root.left)+this.lengthOfTheNode(root.right),this.inorderTraversal(root.right)));
        }
        return 0;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter = this.Traversal(root);
        return diameter;
    }
}

// TIME COMPLEXITY : O(N*N) WHERE N IS THE NUMBER OF NODES IN THE BINARY TREE AND FOR EACH NODE WE ARE FINDING THE HEIGHT OF THE LEFT AND RIGHT SUBTREE.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE BINARY TREE.

