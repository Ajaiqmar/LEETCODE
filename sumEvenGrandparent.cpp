// THE PROBLEM STATEMENT IS TO FIND THE SUM OF ALL THE NODE VALUES WHOSE GRANPARENT NODE VALUE IS EVEN, IF EXISTS. GRANDPARENT NODE IS THE PARENT OF THE PARENT NODE TO
// THE GIVEN NODE.

// MY APPROACH IS TO DO A DFS TRAVERSAL AND KEEP IN CHECK OF THE PARENT AND GRANDPARENT NODE IN THE PARAMETERS, IF THE GRAND PARENT NODE VALUE IS EVEN THEN ADD THE
// CURRENT NODE VALUE TO THE ANS VARIABLE. FINALLY RETURN THE ANS VARIABLE. 

class Solution {
public:
    // FUNCTION TO TRAVERSE THE GIVEN BINARY TREE. 
    void traversal(TreeNode* root,TreeNode* p,TreeNode* gp,int* ans)
    {
        if(root != NULL)
        {
            if(gp != NULL && (gp->val)%2 == 0)
            {
                *ans += (root->val);
            }
            traversal(root->left,root,p,ans);
            traversal(root->right,root,p,ans);
        }
    }
    
    int sumEvenGrandparent(TreeNode* root) 
    {
        int ans = 0;
        traversal(root,NULL,NULL,&ans);
        
        return ans;
    }
};

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE BINARY TREE.
