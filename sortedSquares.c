
int* sortedSquares(int* nums, int numsSize, int* returnSize)
{
    int* ans = (int*)malloc(sizeof(int)*numsSize);
    *returnSize = numsSize;
    int index = 0,i,j;
    
    while(index < numsSize && nums[index] < 0)
    {
        index++;
    }
    
    i = index-1;
    j = index;
    index = 0;
    
    while(index < numsSize)
    {
        if(i >= 0 && j == numsSize)
        {
            ans[index++] = nums[i]*nums[i];
            i--;
        }
        else if(i < 0 && j < numsSize)
        {
            ans[index++] = nums[j]*nums[j];
            j++;
        }
        else if(abs(nums[i]) < abs(nums[j]))
        {
            ans[index++] = nums[i]*nums[i];
            i--;
        }
        else
        {
            ans[index++] = nums[j]*nums[j];
            j++;
        }
    }
    
    return ans;
}
