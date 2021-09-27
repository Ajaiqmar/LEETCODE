// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF PRIME SET BITS PRESENT IN THE RANGE FROM LEFT TO RIGHT. HOW TO FIND THE PRIME SET BITS, WHEN GIVEN AN INTEGER
// WE HAVE TO FIND THE NUMBER OF SET BITS, THEN WE HAVE TO CHECK IF THE NUMBER OF SET BITS IS A PRIME NUMBER. 

// MY APPROACH IS SINCE AN INTEGER IS REPRESENTED
// IN THE FORM OF 32-BITS, SO THE PRIME NUMBERS BETWEEN 0 AND 31 ARE [2,3,5,7,11,13,17,19,23,29,31]. HENCE WE JUST HAVE TO FIND THE NUMBER OF SET BITS
// OF THE INTEGERS AND THEN DO A BINARY SEARCH TO CHECK IF IT IS PRIME.

class Solution {
    // FUNCTION TO CONVERT DECIMAL TO BINARY.
    public static int countSetBits(int x)
    {
        int count = 0;
        
        while(x!=0)
        {
            if(x%2 == 1)
            {
                count++;
            }
            x= x/2;
        }
        
        return count;
    }
    
    public int countPrimeSetBits(int left, int right) 
    {
        int[] primes = {2,3,5,7,11,13,17,19,23,29,31};
        int ans = 0;
        
        // TRAVERSING THE RANGE FROM LEFT TO RIGHT
        for(int i=left;i<=right;i++)
        {
            if(Arrays.binarySearch(primes,countSetBits(i)) >= 0)
            {
                ans++;
            }
        }
        return ans;
    }
}

// TIME COMPLEXITY : O(N LOG N)
// SPACE COMPLEXITY : O(1) SINCE THE NUMBER OF PRIME NUMBERS BETWEEN 0 AND 31 DOESN'T GROW LINEARLY.
