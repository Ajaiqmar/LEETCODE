// THE PROBLEM STATEMENT IS TO RETURN THE DIAMETER OF A BINARY TREE. THE DIAMETER OF A BINARY TREE IS THE LONGEST PATH BETWEEN TWO NODES.

// APPROACH - 2 : MY APPROACH IS TO TRAVERSE THE GIVEN BINARY TREE RECURSIVELY , WHILE TRAVERSING FIND THE HEIGHT OF EACH NODE'S LEFT AND RIGHT SUBTREE USING
// THE HEIGHT VARIABLE, NOW CHECK IF THE SUM IS GREATER THAN THE CURRENT DIAMETER, IF IT IS ASSIGN ITS VALUE TO IT. THEN FINALLY RETURN THE DIAMETER VALUE.

class Solution 
{
    public:
        int diameter = 0;
        
        // FUNCTION TO TRAVERSE THE BINARY TREE.
        int traversal(TreeNode* root,int height)
        {
            if(root == NULL)
            {
                return 0;
            }
            
            int lh = traversal(root->left,height);
            int rh = traversal(root->right,height);
            
            diameter = max(diameter,lh+rh);
            
            return 1+max(lh,rh);
        }
        
        int diameterOfBinaryTree(TreeNode* root) 
        {
            traversal(root,0);
            return diameter;
        }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(H)
