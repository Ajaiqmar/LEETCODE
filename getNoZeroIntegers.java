// THE PROBLEM STATEMENT IS TO RETURN TWO NON-ZERO INTEGERS WHOSE SUM IS EQUAL TO N.
// NON - ZERO INTEGERS ARE THE ONE THAT CONTAINS NO ZEROES IN THEIR DECIMAL REPRESENTATION.

// MY APPROACH IS TO APPLY THE BRUTE FORCE APPROACH BY TRAVERSING FROM 1 TO N-1 AND CHECKING WHETHER I AND N-I IS A NON - ZERO INTEGER.

class Solution 
{
    // FUNCTION TO CHECK WHETHER THE GIVEN NUMBER IS NON - ZERO INTEGER OR NOT.
    public Boolean checkForZero(int n)
    {
        while(n!=0)
        {
            if(n%10 == 0)
            {
                return false;
            }
            n = n/10;
        }
        
        return true;
    }
    
    public int[] getNoZeroIntegers(int n) 
    {
        int[] ans = new int[2];
        
        // TRAVERSING FROM 1 TO N-1.
        for(int i=1;i<n;i++)
        {
            if(checkForZero(i) && checkForZero(n-i))
            {
                ans[0] = i;
                ans[1] = n-i;
                break;
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N LOG N)
// SPACE COMPLEXITY : O(1)
