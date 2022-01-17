// PROBLEM DESCRIPTION : https://leetcode.com/problems/maximize-distance-to-closest-person/

// MY APPROACH IS TO TRAVERSE THE GIVEN SEATS ARRANGEMENT ARRAY, AND FIND THE NUMBER OF ZEROS IN BETWEEN THE ONES IN THE ARRAY, THEN FIND THE MAXIMUM BETWEEN ALL THE
// NUMBER OF ZEROS BETWEEN THE ARRAY DIVIDED BY 2.

class Solution 
{
    public int maxDistToClosest(int[] seats) 
    {
        int ind = 0,ans = 0;
        
        // FINDING OUT THE NUMBER OF ZEROS IN FRONT OF THE ARRAY.
        while(ind < seats.length && seats[ind] == 0)
        {
            ans += 1;
            ind += 1;
        }
        
        int c = 0;
        
        // FINDING THE MAXIMUM DISTANCE TO THE CLOSEST PERSON BY COUNTING THE NUMBER OF ZEROS IN BETWEEN THE ONES.
        for(int i=ind;i<seats.length;i++)
        {
            if(seats[i] == 1)
            {
                if(c%2 == 0)
                {
                    ans = Math.max(ans,(c/2));
                }
                else
                {
                    ans = Math.max(ans,((c/2)+1));
                }
                
                c = 0;
            }
            else
            {
                c += 1;
            }
        }
        
        ans = Math.max(ans,c);
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
