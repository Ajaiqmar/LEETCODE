struct TreeNode* NewRoot;
struct TreeNode* lastInsertedNode;

void inorder(struct TreeNode* root)
{
    if(root != NULL)
    {
        inorder(root->left);
        struct TreeNode* rightNode = NULL;
        if(NewRoot == NULL)
        {
            rightNode = root->right;
            root->left = NULL;
            root->right = NULL;
            NewRoot = root;
            lastInsertedNode = root;
        }
        else
        {
            rightNode = root->right;
            root->left = NULL;
            root->right = NULL;
            lastInsertedNode->right = root;
            lastInsertedNode = root;
        }
        inorder(rightNode);
    }
}

struct TreeNode* increasingBST(struct TreeNode* root)
{
    NewRoot = NULL;
    lastInsertedNode = NULL;
    
    inorder(root);
    
    return NewRoot;
}
