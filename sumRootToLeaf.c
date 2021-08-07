// THE PROBLEM STATEMENT IS TO RETURN THE SUM OF THE DECIMAL VALUES OF THE BINARY NUMBERS OBTAINED FROM EACH PATH OF THE GIVEN BINARY TREE.
// THE ROOT NODE POINTS TO MOST SIGNIFICANT BIT.

// MY APPROACH IS TO DO A DFS TRAVERSAL OF THE GIVEN BINARY TREE, WHILE TRAVERSING KEEP INCREMENTING THE PATHVALUE BY LEFT SHIFTING THE BINARY DIGIT BY A SINGLE
// PLACE AND THEN XOR IT WITH THE CURRENT NODE VALUE.

// DFS TRAVERSAL(INORDER TRAVERSAL)

int inorder(struct TreeNode* root,int pathValue)
{
    if(root != NULL)
    {
        if(root->left != NULL && root->right != NULL)
        {
            return inorder(root->left,((pathValue<<1)^root->val))+inorder(root->right,((pathValue<<1)^root->val));
        }
        else if(root->left != NULL)
        {
            return inorder(root->left,((pathValue<<1)^root->val));
        }
        else if(root->right != NULL)
        {
            return inorder(root->right,((pathValue<<1)^root->val));
        }
    }
    return ((pathValue<<1)^root->val);
}

int sumRootToLeaf(struct TreeNode* root){
    return inorder(root,0);
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES IN THE BINARY TREE.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGH OF THE BINARY TREE.
