// THE PROBLEM STATEMENT IS TO RETURN AN ARRAY CONTAINING ALL THE ELEMENTS IN THE GIVEN BINARY SEARCH TREES IN ASCENDING ORDER.

// MY APPROACH IS TO FIRST DO AN INORDER TRAVERSAL OF THE GIVEN BINARY SEARCH TREES AND STORE THEM IN TWO DIFFERENT ARRAYS, THIS WILL YIELD TWO
// SORTED ARRAYS, THEN DO A TWO POINTERS AND TRAVERSE THE ARRAYS TO GET THE COMBINATION OF BOTH ARRAYS IN SORTED ORDER. FINALLY RETURN 
// THE ARRAY.

class Solution 
{
    // FUNCTION TO TRAVERSE THE GIVEN BINARY SEARCH TREE.
    public void inorderTraversal(TreeNode root,List<Integer> arr)
    {
        if(root != null)
        {
            inorderTraversal(root.left,arr);
            arr.add(root.val);
            inorderTraversal(root.right,arr);
        }
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2)
    {
        List<Integer> arr1 = new ArrayList<Integer>();
        inorderTraversal(root1,arr1);
        
        List<Integer> arr2 = new ArrayList<Integer>();
        inorderTraversal(root2,arr2);
        
        // USING TWO POINTER APPROACH TO MERGE THE TWO SORTED ARRAYS.
        int n = arr1.size(),m = arr2.size(),i = 0,j = 0;
        List<Integer> ans = new ArrayList<Integer>();
        
        while(i < n && j < m)
        {
            int a = arr1.get(i),b = arr2.get(j);
            if(a <= b)
            {
                ans.add(a);
                i += 1;
            }
            else
            {
                ans.add(b);
                j += 1;
            }
        }
        
        while(i < n)
        {
            ans.add(arr1.get(i));
            i += 1;
        }
        
        while(j < m)
        {
            ans.add(arr2.get(j));
            j += 1;
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(MAX(M,N))
// SPACE COMPLEXITY : O(M+N)
