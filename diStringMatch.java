// THE PROBLEM STATEMENT IS TO RETURN A PERMUTATION ARRAY CALLED PERM THAT CONTAINS INTEGERS FROM 0 TO S.LENGTH() FORMED USING THE STRING. THE STRING ONLY CONTAINS 
// CHARACTER 'I' AND 'D'. IF THE CHARACTER IS 'I' , THEN PERM[I] < PERM[I+1] ELSE IF THE CHARACTER IS 'D' , THEN PERM[I] > PERM[I+1].

// SINCE THIS IS A GREEDY PROBLEM.
// MY APPROACH IS TO TRAVERSE THE PERM ARRAY OF LENGTH S.LENGTH()+1 AND CHECK FOR CERTAIN CONDITIONS DEPENDING UPON WHICH THE VALUES WILL BE INSERTED. WE WILL
// ALSO HAVE L AND R INITIALISED TO 0 AND S.LENGTH() RESPECTIVELY.

class Solution 
{
    public int[] diStringMatch(String s) 
    {
        int n = s.length()+1,l = 0,r = s.length();
        int[] ans = new int[n];
        
        // TRAVERSING THE PERM ARRAY.
        for(int i=0;i<n;i++)
        {
            if(i == 0)
            {
                if(s.charAt(i) == 'I')
                {
                    ans[i] = l;
                    l += 1;
                }
                else
                {
                    ans[i] = r;
                    r -= 1;
                }
            }
            else if(i == n-1)
            {
                ans[i] = l;
                l += 1;
            }
            else
            {
                if(s.charAt(i) == 'I' && s.charAt(i) == 'I')
                {
                    ans[i] = l;
                    l += 1;
                }
                else if(s.charAt(i) == 'D' && s.charAt(i) == 'D')
                {
                    ans[i] = r;
                    r -= 1;
                }
                else if(s.charAt(i) == 'D' && s.charAt(i) == 'I')
                {
                    ans[i] = l;
                    l += 1;
                }
                else if(s.charAt(i) == 'I' && s.charAt(i) == 'D')
                {
                    ans[i] = r;
                    r -= 1;
                }
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
