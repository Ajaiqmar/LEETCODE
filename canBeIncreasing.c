bool canBeIncreasing(int* nums, int numsSize){
    int countOfDecreasing = 0;
    
    for(int i=1;i<numsSize;i++)
    {
        if(i == 1)
        {
            if(nums[i] <= nums[i-1])
            {
                countOfDecreasing+=1;
            }
        }
        else
        {
            if(nums[i] <= nums[i-1] && nums[i] <= nums[i-2] && i<numsSize-1 && nums[i+1]<=nums[i-1])
            {
                return false;
            }
            else if(nums[i] <= nums[i-1])
            {
                countOfDecreasing+=1;
            }
        }
    }
    
    ifcountOfDecreasing == 1 || countOfDecreasing == 0)
    {
        return true;
    }
    
    return false;
}
