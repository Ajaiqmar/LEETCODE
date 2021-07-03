class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = Math.max(0,gain[0]);
        
        for(int i=1;i<gain.length;i++)
        {
            gain[i] = gain[i]+gain[i-1];
            
            if(gain[i] > highestAltitude)
            {
                highestAltitude = gain[i];
            }
        }
        return highestAltitude;
    }
}
