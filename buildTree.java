// THE PROBLEM STATEMENT IS TO CONSTRUCT THE BINARY TREE USING THE IN-ORDER TRAVERSAL AND PRE-ORDER TRAVERSAL OF THAT TREE.

// MY APPROACH IS TO USE A STACK DATA STRUCTURE, FIRSTLY SET THE PREORDER'S FIRST ELEMENT TO BE THE ROOT OF THE BINARY TREE THEN
// PUSH THE VALUES IN THE PREORDER TRAVERSAL AND SET THE TOP ELEMENT'S LEFT POINTER TO THE CURRENT INSERTION ELEMENT
// IF THE PREV VALUE IS NULL, ELSE SET THE PREV ELEMENTS RIGHT POINTER TO THE CURRENT INSERTION ELEMENT
// UNTIL INORDER[J] IS NOT EQUAL TO THE TOP ELEMENT OF THE STACK, THEN POP THE STACK UNTIL THE TOP ELEMENT OF THE STACK IS EQUAL TO INORDER[J]
// REPEAT THIS PROCESS UNTIL I IS LESS THAN PREORDER.LENGTH.

// IN SHORT, WE ARE SLICING THE BINARY TREE AS LEFT SKEWED TREES,

//        3
//      /   \
//    9       20
//          /    \
//        15       7

// AFTER SLICING, [9 3] [15 20] [7], IF YOU LOOK AT IT IN THE FORM OF ARRAY, IT IS THE INORDER TRAVERSAL OF THE ARRAY. WE CAN MAKE USE OF THE PREORDER
// TRAVERSAL TO PINPOINT THE HEAD OF THE LEFT SKEWED TREE.

class Solution 
{
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        // DECLARING AND INITIALISING THE STACK DATA STRUCTURE.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // DECLARING AND INITIALISING THE HEAD OF THE BINARY TREE.
        TreeNode root = new TreeNode(preorder[0]);
        root.left = null;
        root.right = null;
        
        stack.push(root);
        
        int i=1,j=0;
        TreeNode prev = null;
        
        // TRAVERSING THE PREORDER AND THE INORDER ARRAY.
        while(i < preorder.length)
        {
            while(stack.size() == 0 || stack.peek().val != inorder[j])
            {
                TreeNode temp = new TreeNode(preorder[i]);
                temp.left = null;
                temp.right = null;
                i += 1;
                
                if(prev != null)
                {
                    prev.right = temp;
                    prev = null;
                }
                else
                {
                    TreeNode node = stack.peek();
                    node.left = temp;
                }
                
                stack.push(temp);
            }
            
            while(stack.size() > 0 && stack.peek().val == inorder[j])
            {
                prev = stack.pop();
                j += 1;
            }
        }
        
        return root;
    }
}

// TIME COMPLEXITY : O(M*L) WHERE M IS THE NUMBER OF LEFT SKEWED TREES AND L IS THE MAXLENGTH OF THE LEFT SKEWED TREE.
// SPACE COMPLEXITY : O(L)
