// THE PROBLEM STATEMENT IS TO RETURN THE MAXIMUM PATH SUM OF THE GIVEN BINARY TREE. A PATH SUM IS DEFINED AS THE SUM OF THE VALUE OF THE NODES PRESENT IN THE
// PATH BETWEEN TWO NODES.

// MY APPROACH IS TRAVERSE THE GIVEN BINARY TREE AND FIND THE MAXIMUM PATH BETWEEN TWO NODES RECURSIVELY. WHILE TRAVERSING EACH NODES, WE WILL
// GET MAXIMUM LEFT PATH SUM AND MAXIMUM RIGHT PATH SUM, WE WILL THEN COMPARE IF THE CURRENT PATH SUM IS GREATER THAN THE MAXIMUM PATH SUM, SINCE THE PATH CAN EXIST
// BETWEEN ANY TWO NODES, WE NEED TO CONSIDER LEFT SKEWED, RIGHT SKEWED PATH SUM AS WELL. THEN RETURN THE MAXIMU OF LEFT SKEWED, RIGHT SKEWED AND CURRENT NODE VALUE TO
// THE PARENT NODES FUNCTION CALL.

class Solution {
public:
    // FUNCTION TO TRAVERSE THE GIVEN BINARY TREE.
    int pathSum(TreeNode* root,int* mps)
    {
        if(root == NULL)
        {
            return 0;
        }
        
        int lps = pathSum(root->left,mps);
        int rps = pathSum(root->right,mps);
        
        *mps = max(*mps,lps+rps+root->val);
        *mps = max(*mps,lps+root->val);
        *mps = max(*mps,rps+root->val);
        *mps = max(*mps,root->val);
        
        return max(lps+root->val,max(rps+root->val,root->val));
    }
    
    int maxPathSum(TreeNode* root) 
    {
        int mps = INT_MIN;
        pathSum(root,&mps);
        
        return mps;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(H)
