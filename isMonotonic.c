bool isMonotonic(int* nums, int numsSize){
    int monotoneIncreasing = 1,monotoneDecreasing = 1;
    
    for(int i=1,j=numsSize-2;i<numsSize;i++,j--)
    {
        if(nums[i] < nums[i-1])
        {
            monotoneIncreasing = 0;
        }
        if(nums[j] < nums[j+1])
        {
            monotoneDecreasing = 0;
        }
    }
    
    return (monotoneIncreasing || monotoneDecreasing);
}
