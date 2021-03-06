// THE PROBLEM STATEMENT IS TO FIND ALL THE DUPLICATES PRESENT IN THE GIVEN ARRAY WHERE EACH ELEMENT IN THE ARRAY WILL BE BETWEEN 1 AND N.
// THE ELEMENTS IN THE ARRAY CAN OCCUR ATMOST TWICE IN THE ARRAY.

// FOLLOW UP: THEY WERE ASKING US TO CHOOSE AN ALGORITHM THAT HAS O(N) TIME COMPLEXITY AND O(1) SPACE COMPLEXITY.

// SINCE THE VALUES ARE GOING TO BE IN THE RANGE OF 1 TO N, WE COULD USE THIS TO OUR ADVANTAGE BY CONVERTING THEM AS INDICES OF THE ARRAY.

// SO MY APPROACH IS TO TRAVERSE THE ARRAY, AND AT EVERY INDEX I, WE CONVERT THE NUMBER AT THAT INDEX AS AN INDEX OF THE ARRAY AND CONVERT THE ELEMENT AT
// THAT INDEX TO A NEGATIVE VALUE. SO IF NUMS[I] IS NEGATIVE THEN IT ALREADY CONTAINS THAT VALUE. SINCE THE ELEMENTS CAN ONLY OCCUR A MAXIMUM OF TWO TIMES.
// WE WOULD BE ABLE TO PINPOINT THE DUPLICATES IN THE GIVEN ARRAY.

int* findDuplicates(int* nums, int numsSize, int* returnSize)
{
    int* ans = (int*)malloc(sizeof(int)*numsSize);
    int ansSize = 0;
    
    // TRAVERSING THE ARRAY TO FIND OUT THE DUPLICATES IN THE GIVEN ARRAY.
    for(int i=0;i<numsSize;i++)
    {
        int ind = ((nums[i] < 0)?-nums[i]:nums[i])-1;
        
        if(nums[ind] < 0)
        {
            ans[ansSize++] = ind+1;
        }
        else
        {
            nums[ind] = -nums[ind];
        }
    }
    
    *returnSize = ansSize;
    
    return ans;
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
