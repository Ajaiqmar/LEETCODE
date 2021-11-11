// THE PROBLEM STATEMENT IS TO CONSTRUCT A BINARY SEARCH TREE WHEN THE PREORDER TRAVERSAL OF THE TREE IS GIVEN.

// MY APPROACH IS TO USE A STACK DATA STRUCTURE AND CONSTRUCT THE BINARY SEARCH TREE. FIRTLY, WE WILL INSERT ROOT OF THE BINARY SEARCH TREE ONTO THE STACK
// , WHICH IS THE FIRST ELEMENT IN THE PREORDER TRAVERSAL. THEN WE WILL TRAVERSE THE ARRAY FROM INDEX 1, FOR EACH VALUE, WE WILL CHECK IF THE VALUE
// IS LESS THAN THE TOP ELEMENT OF THE STACK, IF IT IS WE WILL INITIALISE THE LEFT POINTER OF THE TOP NODE IN THE STACK TO A TREENODE WITH THE CURRENT VALUE AND THEN
// INSERT THAT NODE ONTO THE STACK. ELSE WE WILL POP THE STACK UNTIL THE VALUE IS LESSER THAN THE TOP ELEMENT OF THE STACK OR UNTIL THE
// STACK IS EMPTY AND ALSO WE WILL KEEP IN CHECK OF THE LAST ELEMENT POPPED. THEN WE SHOULD INITIALISE THE LAST POPPED ELEMENTS RIGHT POINTER TO
// A TREENODE WITH THE CURRENT VALUE AND INSERT THAT NODE ONTO THE STACK.

class Solution 
{   
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        // INITIALISING THE STACK DATA STRUCTURE.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        
        // CREATING THE BINARY SEARCH TREE FROM THE GIVEN PREORDER TRAVERSAL OF THE TREE.
        for(int i=1;i<preorder.length;i++)
        {
            TreeNode node = stack.pop();
            while((!stack.empty()) && stack.peek().val < preorder[i] && node.val < preorder[i])
            {
                node = stack.pop();
            }
            
            if(node.val > preorder[i])
            {
                TreeNode temp = new TreeNode(preorder[i]);
                node.left = temp;
                stack.push(node);
                stack.push(temp);
            }
            else
            {
                TreeNode temp = new TreeNode(preorder[i]);
                node.right = temp;
                stack.push(temp);
            }
        }
        
        return root;
    }
}

// TIME COMPLEXITY : O(N*H) 
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE TREE.
