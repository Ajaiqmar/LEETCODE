int maxProductDifference(int* nums, int numsSize){
    int highest = 0,secondHighest = 0,lowest = 10001,secondLowest = 10001;
    
    for(int i=0;i<numsSize;i++)
    {
        if(nums[i] > highest)
        {
            secondHighest = highest;
            highest = nums[i];
        }
        else if(nums[i] > secondHighest)
        {
            secondHighest = nums[i];
        }
        
        if(nums[i] < lowest)
        {
            secondLowest = lowest;
            lowest = nums[i];
        }
        else if(nums[i] < secondLowest)
        {
            secondLowest = nums[i];
        }
    }
    
    return ((highest*secondHighest)-(lowest*secondLowest));
}
