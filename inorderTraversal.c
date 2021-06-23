struct TreeNode{
  int val;
  struct TreeNode* left;
  struct TreeNode* right;
};

void inorder(struct TreeNode* root,int* arr,int* ind)
{
    if(root != NULL)
    {
        inorder(root->left,arr,ind);
        arr[*ind] = root->val;
        *ind += 1;
        inorder(root->right,arr,ind);
    }
}

int* inorderTraversal(struct TreeNode* root, int* returnSize){
    int* ans = (int*)malloc(sizeof(int)*100);
    int ind = 0;
    
    inorder(root,ans,&ind);
    
    *returnSize = ind;
    
    return ans;
}
