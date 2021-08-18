// THE PROBLEM STATEMENT IS TO RETURN THE MAXIMUM PRODUCT OF INTEGERS IN TWO DIFFERENT INDICES. I.E. (ARR[I]-1)*(ARR[J]-1).

// MY APPROACH IS TO TRAVERSE THE ARRAY AND FIND THE MAXIMUM AND SECOND MAXIMUM IN AN ARRAY. THE RETURN THEIR PRODUCT. 

int maxProduct(int* nums, int numsSize)
{
    int max = INT_MIN,s_max = INT_MIN;
    
    // TRAVERSE THE ARRAY TO FIND THE MAXIMUM AND SECOND MAXIMUM.
    for(int i=0;i<numsSize;i++)
    {
        if(nums[i] >= max)
        {
            s_max = max;
            max = nums[i];
        }
        else if(nums[i] > s_max)
        {
            s_max = nums[i];
        }
    }
    
    return (max-1)*(s_max-1);
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
