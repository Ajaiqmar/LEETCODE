// THE PROBLEM STATEMENT IS TO RETURN THE ROOT OF A BALANCED BINARY SEARCH TREE GIVEN THE ROOT OF A BINARY SEARCH TREE.

// MY FIRST APPROACH WAS TO USE AVL TREE INSERTION FORMAT BUT THAT ENDED IN VAIN BECAUSE CERTAIN NODES NEEDED TO BE VISITED AGAIN
// AND AGAIN. SO THE NEXT APPROACH I CAME ACROSS WAS TO DO AN INORDER TRAVERSAL OF THE GIVEN BST AND STORE THE ELEMENTS IN A ARRAY, THEN FORM 
// A BALANCED BST USING DIVIDE AND CONQUER METHOD.

class Solution 
{
    // FUNCTION TO TRAVERSE THE BINARY SEARCH TREE.
    public void inorder(TreeNode root,ArrayList<Integer> nodes)
    {
        if(root != null)
        {
            inorder(root.left,nodes);
            nodes.add(root.val);
            inorder(root.right,nodes);
        }
    }
    
    // FUNCTION TO CREATE BALANCED BST.
    public TreeNode createBalancedBST(ArrayList<Integer> nodes,int left,int right)
    {
        if(left <= right)
        {
            int mid = left+((right-left)/2);
            TreeNode temp = new TreeNode();
            temp.val = nodes.get(mid);
            
            temp.left = createBalancedBST(nodes,left,mid-1);
            temp.right = createBalancedBST(nodes,mid+1,right);
            
            return temp;
        }
        
        return null;
    }
    
    public TreeNode balanceBST(TreeNode root) 
    {
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        
        inorder(root,nodes);
        
        return createBalancedBST(nodes,0,(nodes.size()-1));
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF ELEMENTS IN THE BINARY SEARCH TREE.
// SPACE COMPLEXITY : O(N)
