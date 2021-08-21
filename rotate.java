// THE PROBLEM STATEMENT IS TO ROTATE THE ARRAY CLOCKWISE.
// THE FOLLOW UP QUESTION IS TO CARRY OUT THE FUNCTION IN O(1) SPACE.

// MY APPROACH IS TO FIRST REDUCE THE K VALUE BELOW THE LENGTH OF THE NUMS ARRAY. THEN PARTITION THE ARRAY INTO TWO PARTS AS ARR[0:N-K] AND ARR[N-K:N].
// NOW REVERSE THE SUBARRAYS SEPERATELY THEN REVERSE THE WHOLE ARRAY, WHICH WILL YIELD THE ROTATED IN  O(1) SPACE.

class Solution 
{
    // REVERSING THE GIVEN ARRAY.
    public static int[] reverse(int[] nums,int left,int right)
    {
        while(left < right)
        {
            int temp = nums[left];
            nums[left]= nums[right];
            nums[right] = temp;
            left += 1;
            right -= 1;
        }
        
        return nums;
    }
    
    public void rotate(int[] nums, int k) 
    {   
        k = k%nums.length;
        
        if(k == 0)
        {
            return ;
        }
        
        nums = reverse(nums,0,(nums.length-k)-1);
        nums = reverse(nums,(nums.length-k),(nums.length-1));
        nums = reverse(nums,0,(nums.length-1));
        
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
