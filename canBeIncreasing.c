// THE PROBLEM STATEMENT IS TO CHECK IF THE ARRAY IS STRICTLY INCREASING AFTER REMOVING ATMOST ONE ELEMENT FROM THE ARRAY.

// MY APPROACH IS TO TRAVERSE THE ARRAY AND CHECK FOR DIPS IN THE FLOW OF THE INTEGERS THAT IS CHECK IF AN INTEGER AT INDEX I IS LESS THAN OR
// EQUAL TO THE INTEGER AT INDEX I-1. IF DIPS IS MORE THAN 1 THEN RETURN FALSE ELSE RETURN TRUE. ALSO IT IS NECESSARY TO CHECK IF THE ELEMENT AT INDEX I IS LESS THAN OR
// EQUAL TO THE ELEMENT AT INDEX I-2. IF IT IS THEN RETURN FALSE DIRECTLY.

bool canBeIncreasing(int* nums, int numsSize){
    int countOfDecreasing = 0;
    
    // TRAVERSING THE ARRAY TO CHECK FOR THE DIPS.
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

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
