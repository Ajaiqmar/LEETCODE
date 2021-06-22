int* findDisappearedNumbers(int* nums, int numsSize, int* returnSize){
    
    int* ans = (int*)malloc(sizeof(int)*numsSize);
    int ind=0;
    
    for(int i=0;i<numsSize;i++)
    {
        int v = abs(nums[i])-1;
        nums[v] = ((nums[v]>0)?-nums[v]:nums[v]);
    }
    
    for(int i=0;i<numsSize;i++)
    {
        if(nums[i]>0)
        {
            ans[ind] = i+1;
            ind += 1;
        }
    }
    
    *returnSize = ind;
    
    return ans;
}
