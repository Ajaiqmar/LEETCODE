// THE PROBLEM STATEMENT IS TO RETURN SUM OF ALL THE INTEGERS THAT WE OBTAIN BY EXPLORING ALL THE PATHS OF THE BINARY TREE FROM ROOT TO THE LEAF NODES.

// MY APPROACH IS TO TRAVERSE THE GIVEN BINARY TREE USING DFS PREORDER TRAVERSAL, WHILE TRAVERSING ADD EACH DIGIT TO THE VALUE INTEGER, THEN
// IF THE NODE IS A LEAF NODE RETURN THE VALUE INTEGER.

class Solution 
{
    // DFS TRAVERSAL
    public static int preorder(TreeNode root, int value)
    {
        if(root == null)
        {
            return 0;
        }
        
        if(root.left == null && root.right == null)
        {
            value = (value*10)+root.val;
            return value;
        }
        
        value = (value*10)+root.val;
        
        return preorder(root.left,value)+preorder(root.right,value);
    }
    
    public int sumNumbers(TreeNode root) 
    {
        return preorder(root,0);
    }
}

// TIME COMPLEXITY : O(N) WHERE N BEING THE TOTAL NUMBER OF NODES.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE BINARY TREE.
