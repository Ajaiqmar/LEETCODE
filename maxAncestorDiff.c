// THE PROBLEM STATEMENT IS TO FIND THE MAXIMUM DIFFERENCE BETWEEN TWO NODES IN A BINARY TREE SUCH THAT ONE NODE IS THE ANCESTOR OF THE OTHER NODE.

// MY APPROACH IS TO USE DEPTH FIRST SEARCH AND TRAVERSE THE BINARY TREE WHILE TRAVERSING KEEP IN CHECK OF THE MAXIMUM AND MINIMUM ANCESTOR VALUE,
// AND FIND THE ABSOLUTE DIFFERENCE OF THE CURRENT NODES VALUE WITH MAXIMUM AND MINIMUM ANCESTOR NODE VALUE, ALSO CHECK IF THE DIFFERENCES ARE GREATER 
// THAN THE CURRENT MAX DIFFERENCE. FINALLY RETURN THE MAX DIFFERENCE.

// FUNCTION TO TRAVERSE THE TREE USING DEPTH FIRST SEARCH.
void findMax(struct TreeNode* root,int* ans,int maxAncestor,int minAncestor)
{
    if(root != NULL)
    {
        if(*ans < abs(root->val-maxAncestor))
        {
            *ans = abs(root->val-maxAncestor);
        }
        
        if(*ans < abs(root->val-minAncestor))
        {
            *ans = abs(root->val-minAncestor);
        }
        
        findMax(root->left,ans,((maxAncestor > root->val)?maxAncestor:root->val),((minAncestor < root->val)?minAncestor:root->val));
        findMax(root->right,ans,((maxAncestor > root->val)?maxAncestor:root->val),((minAncestor < root->val)?minAncestor:root->val));
    }
}

int maxAncestorDiff(struct TreeNode* root)
{
    int ans = 0;
    findMax(root,&ans,root->val,root->val);
    
    return ans;
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES IN THE BINARY TREE.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE TREE.
