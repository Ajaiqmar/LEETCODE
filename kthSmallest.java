// THE PROBLEM STATEMENT IS TO RETURN K-TH SMALLEST VALUE IN A BINARY SEARCH TREE.

// MY APPROACH IS TO DO AN INORDER TRAVERSAL WHICH WILL TRAVERSE THE ARRAY IN SORTED ORDER. WHILE TRAVERSING STORE THE VALUES IN AN ARRAYLIST, THEN RETURN THE VALUE
// AT INDEX K-1.

class Solution 
{
    // FUNCTION TO PERFORM DFS TRAVERSAL(INORDER TRAVERSAL).
    public static void inorderTraversal(TreeNode root,ArrayList<Integer> arr)
    {
        if(root != null)
        {
            inorderTraversal(root.left,arr);
            arr.add(root.val);
            inorderTraversal(root.right,arr);
        }
    }
    
    public int kthSmallest(TreeNode root, int k) 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        inorderTraversal(root,arr);
        
        return arr.get(k-1);
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N) WHERE N IS THE NUMBER OF ELEMENTS IN THE BINARY SEARCH TREE.
