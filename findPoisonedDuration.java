class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        
        for(int i=0;i<timeSeries.length;i++)
        {
            if(i == 0)
            {
                ans += duration;
            }
            else if(timeSeries[i]>=timeSeries[i-1] && timeSeries[i]<=(timeSeries[i-1]+duration-1))
            {
                ans += ((timeSeries[i]+duration-1)-(timeSeries[i-1]+duration-1));
            }
            else
            {
                ans += duration;
            }
        }
        
        return ans;
    }
}
