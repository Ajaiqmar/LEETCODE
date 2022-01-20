// PROBLEM DESCRIPTION : https://leetcode.com/problems/koko-eating-bananas/

// MY APPROACH IS TO USE BINARY SEARCH TO PINPOINT THE MINIMUM NUMBER OF BANANAS TO BE CONSUMED BY KOKO INORDER TO CONSUME
// THE ENTIRE PILES WITHIN H HOURS.

class Solution 
{
    public int minEatingSpeed(int[] piles, int h)
    {
        int l = 1,r = 0;
        // FINDING THE MAX PILE IN THE GIVEN PILES OF BANANAS
        for(int i=0;i<piles.length;i++)
        {
            r = Math.max(r,piles[i]);
        }
        
        int ans = r;
        // USING BINARY SEARCH TO PINPOINT THE MINIMUM NUMBER OF BANANAS TO BE CONSUMED.
        while(l <= r)
        {
            int m = l+((r-l)/2);
            int hours = 0;
            
            for(int i=0;i<piles.length;i++)
            {
                if(piles[i]%m == 0)
                {
                    hours += (piles[i]/m);
                }
                else
                {
                    hours += ((piles[i]/m)+1);
                }
            }
            
            if(hours <= h)
            {
                ans = Math.min(ans,m);
                r = m-1;
            }
            else
            {
                l = m+1;
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N LOG M) WHERE M IS THE MAX PILE IN THE NUMBER OF PILES OF BANANAS.
// SPAVCE COMPLEXITY :O(1)
