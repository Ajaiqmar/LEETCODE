// THE PROBLEM STATEMENT IS TO RETURN THE ELEMENTS ON THE RIGHTMOST CORNER OF EACH LEVEL IN A BINARY TREE DATA STRUCTURE.

// MY APPROACH IS TO DO A PREORDER TRAVERSAL OF THE BINARY, BUT THERE IS A TWIST, INSTEAD OF VISITING THE LEFT SUBTREE FIRST WE WILL BE VISITING THE RIGHT SUBTREE
// FIRST THEN VISIT THE LEFT SUBTREE. BY THIS FUNCTION WE WILL BE ABLE TO VISIT THE RIGHT MOST ELEMENTS ON EACH LEVEL OF A BINARY TREE.
// NOW, WE JUST HAVE TO INSERT THE VALUES ONTO THE ARRAY.

class Solution {
    // FUNCTION TO TRAVERSE THE BINARY TREE.
    public static void traversal(TreeNode root,List<Integer> arr,int level)
    {
        if(root != null)
        {
            if(level == arr.size())
            {
                arr.add(root.val);
            }
            traversal(root.right,arr,level+1);
            traversal(root.left,arr,level+1);
        }
    }
    
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> rightView = new ArrayList<Integer>();
        
        traversal(root,rightView,0);
        
        return rightView;
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES IN THE BINARY TREE.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE BINARY TREE.
