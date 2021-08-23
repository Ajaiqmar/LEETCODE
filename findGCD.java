// THE PROBLEM STATEMENT IS TO RETURN THE GCD OF THE MAXIMUM AND MINIMUM INTEGER IN AN ARRAY.

// MY APPROACH IS TO TRAVERSE THE ARRAY AND FIND THE MINIMUM AND MAXIMUM INTEGER IN THE ARRAY, THEN APPLY THE EUCLIDEAN ALGORITHM TO FIND OUT
// GCD OF TWO NUMBERS.

class Solution {
    // EUCLIDEAN FUNCTION TO FIND THE GCD OF TWO NUMBERS.
    public static int gcd(int a,int b)
    {
        if(b == 0)
        {
            return a;
        }
        else
        {
            return gcd(b,a%b);
        }
    }
   
    public int findGCD(int[] nums) {
        int min = nums[0],max = nums[0];
        
        // TRAVERSING THE ARRAY TO FIND THE MAXIMUM AND MINIMUM INTEGER IN THE ARRAY.
        for(int i=0;i<nums.length;i++)
        {
            if(min < nums[i])
            {
                min = nums[i];
            }
            
            if(max > nums[i])
            {
                max = nums[i];
            }
        }
        
        return gcd(max,min);
    }
}

// TIME COMPLEXITY : O(N + LOG N)
// SPACE COMPLEXITY : O(K) WHERE K IS THE NUMBER OF FUNCTION CALLS FOR THE EUCLIDEAN RECURSIVE FUNCTION.
