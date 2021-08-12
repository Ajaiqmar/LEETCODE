// THE PROBLEM STATEMENT IS TO RETURN A STRING OF LENGTH N SUCH THAT EACH CHARACTER IN THE STRING OCCURS ODD NUMBER OF TIMES.

// MY APPROACH IS TO CHECK WHETHER N IS ODD OR EVEN. IF N IS ODD THEN APPEND N-1 'A' CHARACTER AND 1 'B' CHARACTER TO THE STRING ANS, ELSE APPEND N 'A' CHARACTER
// TO THE STRING ANS.

class Solution 
{
    public String generateTheString(int n) 
    {
        StringBuilder ans = new StringBuilder();
        
        // CHECKING WHETHER N IS EVEN OR ODD.
        if(n%2 == 0)
        {
            for(int i=0;i<n-1;i++)
            {
                ans.append('a');
            }
            ans.append('b');
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                ans.append('a');
            }
        }
        
        return ans.toString();
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXTY : O(N)
