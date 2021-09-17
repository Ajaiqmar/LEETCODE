// THE PROBLEM STATEMENT IS TO FLATTEN THE GIVEN BINARY TREE DATA STRUCTURE INTO A LINKED LIST DATA STRUCTURE.
// IN THE LINKED LIST, EACH NODE IS A TREE NODE WHOSE LEFT POINTER WILL BE NULL AND THE RIGHT POINTER WILL POINT TO THE NEXT NODE IN THE LINKED LIST.
// THE NODES IN THE LINKED LIST WILL BE ARRANGED IN THE ORDER OF PREORDER TRAVERSAL OF THE BINARY TREE.

// MY APPROACH IS TO DO A PREORDER TRAVERSAL (DFS APPROACH), WE WILL HAVE TWO TREENODES ROOT AND HEAD, ROOT REPRESENTS THE NODE OF A BINARY TREE
// AND HEAD REPRESENTS THE TAIL OF LINKED LIST DATA STRUCTURE, AT EACH NODE WE WILL INSERT THAT NODE INTO THE LINKED LIST.

class Solution {
    // FUNCTION TO CARRY OUT PREORDER TRAVERSAL.
    public static TreeNode preorder(TreeNode root,TreeNode head)
    {
        if(root != null)
        {
            TreeNode l = root.left;
            TreeNode r = root.right;
            
            root.left = null;
            root.right = null;
            
            if(head == null)
            {
                head = root;
            }
            else
            {
                head.right = root;
                head = head.right;
            }
            
            head = preorder(l,head);
            head = preorder(r,head);
            
            return head;
        }
        
        return head;
    }
    
    public void flatten(TreeNode root) {
        preorder(root,null);
    }
}

// TIME COMPLEXITY : O(N)N WHERE N IS THE NUMBER OF NODES IJN THE BINARY TREE.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE BINARY TREE.
