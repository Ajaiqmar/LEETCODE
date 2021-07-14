int* getConcatenation(int* nums, int numsSize, int* returnSize){
    int* ans = (int*)malloc(sizeof(int)*(numsSize*2));
    *returnSize = numsSize*2;
    
    for(int i=0;i<(numsSize*2);i++)
    {
        ans[i] = nums[i%numsSize];
    }
    
    return ans;
}
