// THE PROBLEM STATEMENT IS TO RETURN THE LOWEST COMMON ANCESTOR OF THE GIVEN TWO NODES IN THE GIVEN BINARY TREE.

// MY APPROACH IS TO DO A DFS TRAVERSAL OF THE BINARY TREE, WHILE TRAVERSING IF WE ENCOUNTER THE NODES P OR Q WE RETURN TRUE, WE ALSO CHECK IF 
// THE LEFT AND RIGHT SUBTREE HAS RETURNED TRUE, OR WE SHOULD CHECK IF EITHER ONE OF THE SUBTREES HAVE RETURNED TRUE AND THE CURRENT NODE IS EQUAL TO EITHER
// P OR Q NODE. IF IT IS THEN THE CURRENT NODE IS THE LEAST COMMON ANCESTOR.

class Solution 
{
    // DOING A DFS TRAVERSAL OF THE GIVEN BINARY TREE.
    public static Boolean traversal(TreeNode root, TreeNode p, TreeNode q,TreeNode[] ans)
    {
        if(root != null)
        {
            Boolean a = traversal(root.left,p,q,ans);
            Boolean b = traversal(root.right,p,q,ans);
            
            if((a && (root == p || root == q)) || (b && (root == p || root == q)) || (a && b))
            {
                ans[0] = root;
            }
            
            if(root == p || root == q)
            {
                return true;
            }
            
            return a || b;
        }
        
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        TreeNode[] ans = new TreeNode[1];
        traversal(root,p,q,ans);
        
        return ans[0];
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES IN THE BINARY TREE.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE BINARY TREE. 
