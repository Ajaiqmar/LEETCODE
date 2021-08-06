// THE PROBLEM STATEMENT IS TO RETURN AN ARRAY OF LENGTH SAME AS THE GIVEN ARRAY WHICH AT A GIVEN INDEX CONTAINS THE NUMBER OF INTEGERS SMALLER THAN
// INTEGER AT THAT INDEX IN THE GIVEN ARRAY.

// MY APPROACH WAS TO USE COUNTING METHOD WHERE AT EVERY INDEX WE TRAVERSE THE ARRAY AND CHECK FOR INTEGERS LOWER THAN THE INTEGER AT THAT INDEX. THIS APPROACH HAS A TIME 
// COMPLEXITY OF O(N*N).

// BUT SINCE THE CONSTRAINTS ARE SMALLER, EACH INTEGER IN THE ARRAY WILL BE IN THE RANGE OF 0 TO 100. I THOUGHT OF USING HASHTABLE OF LENGTH 101 TO STORE THE
// NUMBER OF OCCURRENCES OF THE INTEGER GIVEN IN THE ARRAY. THEN TRAVERSING THE HASTABLE TO GET NUMBER OF ELEMENTS LESSER THAN THE GIVEN VALUE.

int* smallerNumbersThanCurrent(int* nums, int numsSize, int* returnSize){
    int occurs[101] = {0};
    int smallerOccurences[101] = {0};
    int index = 0;
    int* ans = (int*)malloc(sizeof(int)*numsSize);
    *returnSize = numsSize;
    
    for(int i=0;i<numsSize;i++)
    {
        occurs[nums[i]] += 1;
    }
    
    for(int i=0;i<=100;i++)
    {
        if(occurs[i] > 0)
        {
            smallerOccurences[i] = index;
            index += occurs[i];
        }
    }
    
    for(int i=0;i<numsSize;i++)
    {
        ans[i] = smallerOccurences[nums[i]];
    }
  
    return ans;
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
