// THE PROBLEM STATEMENT IS TO DO AN LEVEL ORDER TRAVERSAL OF A BINARY TREE AND STORE THE VALUES IN EACH LEVEL INTO A TWO DIMENSIONAL MATRIX.

// MY APPROACH IS TO USE A QUEUE DATA STRUCTURE AND STORE THE ROOT INTO THE QUEUE INITIALLY. THEN TRAVERSE EACH LEVEL BY REMOVING THE
// THE TOP ELEMENT AND INSERTING THE CHILD NODES INTO QUEUE DATA STRUCTURE UNTIL THE 
// QUEUE IS EMPTY. WHILE TRAVERSING EACH LEVEL STORE THE VALUE INTO THE ARRAY AND INSERT IT INTO THE TWO DIMENSIONAL ARRAY.

class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        // INITIALISING THE TWO DIMENSIONAL ARRAY.
        List<List<Integer>> levelOrder = new ArrayList<ArrayList<Integer>>();
        // INITIALISING THE QUEUE DATA STRUCTURE.
        List<TreeNode> queue = new ArrayList<TreeNode>();
        
        // INSERT THE ROOT OF THE BINARY TREE.
        if(root == null)
        {
            return levelOrder;
        }
        
        queue.add(root);
        
        // TRAVERSING THE BINARY TREE.
        while(queue.size() != 0)
        {
            List<Integer> arr = new ArrayList<Integer>();
            int length = queue.size();
            
            // TARVERSING EACH LEVEL OF THE BINARY TREE.
            for(int i=0;i<length;i++)
            {
                TreeNode ptr = queue.remove(0);
                
                if(ptr.left != null)
                {
                    queue.add(ptr.left);
                }
                
                if(ptr.right != null)
                {
                    queue.add(ptr.right);
                }
                
                arr.add(ptr.val);
            }
            
            levelOrder.add(arr);
        }
        
        return levelOrder;
    }
}

// TIME COMPLEXITY : O(NUMBER OF NODES)
// SPACE COMPLEXIY : O(NUMBER OF LEVELS IN THE BINARY TREE * MAXIMUM NUMBER OF ELEMENTS IN ALL THE LEVELS)
