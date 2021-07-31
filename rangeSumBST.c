// THE PROBLEM STATEMENT IS TO RETURN THE SUM OF ALL VALUES IN THE INCLUSIVE RANGE OF [LOW,HIGH] IN THE BINARY SEARCH TREE.

// MY APPROACH IS TO DO A DFS (INORDER TRAVERSAL) AND SUM UP ALL THE VALUES THAT ARE IN THE INCLUSIVE RANGE OF [LOW,HIGH].

// INORDER TRAVERSAL
void inorder(struct TreeNode* root,int low,int high,int* sumValue)
{
    if(root != NULL)
    {
        inorder(root->left,low,high,sumValue);
        
        if(root->val >= low && root->val <= high)
        {
            // SUMMING UP ALL THE VALUES THAT ARE IN RANGE.
            *sumValue += root->val;
        }
        
        inorder(root->right,low,high,sumValue);
    }
}


int rangeSumBST(struct TreeNode* root, int low, int high)
{
    int sumValue = 0;
    inorder(root,low,high,&sumValue);
    return sumValue;
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
