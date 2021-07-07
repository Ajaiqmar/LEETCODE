int findLengthOfLCIS(int* nums, int numsSize){
    if(numsSize == 1)
    {
        return 1;
    }
    
    int lis = 0;
    int countOfis = 1;
    
    for(int i=1;i<numsSize;i++)
    {
        if(nums[i] > nums[i-1])
        {
            countOfis += 1;
        }
        else
        {
            countOfis = 1;
        }
        
        if(countOfis > lis)
        {
            lis = countOfis;
        }
    }
    
    return lis;
}
