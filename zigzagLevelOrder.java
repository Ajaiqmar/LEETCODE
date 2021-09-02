// THE PROBLEM STATEMENT IS TO RETURN THE ZIG-ZAG LEVEL ORDER TRAVERSAL OF BINARY TREE DATA STRUCTURE IN A TWO DIMENSIONAL ARRAY.
// I.E.   3
//       / \
//      9   20
//         /  \
//        15   7
// IS THE GIVEN BINARY TREE, THEN ZIG-ZAG LEVEL ORDER TRAVERSAL OF BINARY TREE WOULD BE [[3],[20,9],[15,7]].

// MY APPROACH IS TO USE THE QUEUE DATA STRUCTURE TO DO A NORMAL LEVEL ORDER TRAVERSAL, INSTEAD OF ALWAYS TRAVERSING FROM LEFT TO RIGHT, WE KEEP A 
// FLAG VARAIBLE TO SPECIFY WHICH SIDE WE ARE GOING TO TREAVERSE IN THE GIVEN LEVEL EITHER FROM LEFT TO RIGHT OR FROM RIGHT TO LEFT.

class Solution 
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root == null)
        {
            return ans;
        }
        
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        int flag = 0;
        
        // BFS TRAVERSAL OR LEVEL ORDER TRAVERSAL.
        while(queue.size() > 0)
        {
            int len = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i=0;i<len;i++)
            {
                TreeNode temp = queue.get(i);
                if(temp.left != null)
                {
                    queue.add(temp.left);
                }
                if(temp.right != null)
                {
                    queue.add(temp.right);
                }
            }
            
            // TRAVERSING FROM LEFT TO RIGHT.
            if(flag == 0)
            {
                for(int i=0;i<len;i++)
                {
                    TreeNode temp = queue.get(i);
                    level.add(temp.val);
                }
                flag = 1;
            }
            // TRAVERSING FROM RIGHT TO LEFT.
            else
            {
                for(int i=len-1;i>=0;i--)
                {
                    TreeNode temp = queue.get(i);
                    level.add(temp.val);
                }
                flag = 0;
            }
            
            for(int i=0;i<len;i++)
            {
                queue.remove(0);
            }
            
            ans.add(level);
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF ELEMENTS IN THE BINARY TREE.
// SPACE COMPLEXITY : O(N) WHERE N IS THE NUMBER OF THE ELEMENTS IN THE BINARY TREE.
