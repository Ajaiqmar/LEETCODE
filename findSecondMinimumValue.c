void preOrder(struct TreeNode* root,int* s,int* ss,int* count,int* flag)
{
    if(root != NULL)
    {
        if(root->val == INT_MAX)
        {
            *flag = 1;
        }
        if(root->val < *s)
        {
            *ss = *s;
            *s = root->val;
            *count += 1;
        }
        else if(root->val < *ss && root->val > *s)
        {
            *ss = root->val;
            *count += 1;
        }
        preOrder(root->left,s,ss,count,flag);
        preOrder(root->right,s,ss,count,flag);
    }
}

int findSecondMinimumValue(struct TreeNode* root){
    int smallest = INT_MAX;
    int secondSmallest = INT_MAX;
    int flag = 0,count = 0;
    
    preOrder(root,&smallest,&secondSmallest,&count,&flag);
    
    if(flag == 1 && count == 0)
    {
        return -1;
    }
    else if(flag == 1 && count > 0)
    {
        return secondSmallest;
    }
    else if(secondSmallest == INT_MAX)
    {
        return -1;
    }
    else
    {
        return secondSmallest;
    }
}
