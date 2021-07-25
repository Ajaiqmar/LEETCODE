bool preorder(struct TreeNode* root)
{
    if(root != NULL)
    {
        bool a = true,b = true;
        
        if(root->left != NULL)
        {
            a = (root->left->val == root->val);
        }
        
        if(root->right != NULL)
        {
            b = (root->right->val == root->val);
        }
        
        return a && b && preorder(root->left) && preorder(root->right);
    }
    return true;
}

bool isUnivalTree(struct TreeNode* root){
    return preorder(root);
}
