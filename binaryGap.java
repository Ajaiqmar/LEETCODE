class Solution {
    public int binaryGap(int n) {
        int longestDistance = 0,index = 0,prevOneIndex = -1;
        
        while(n != 0)
        {
            if(n%2 == 1)
            {
                if(prevOneIndex == -1)
                {
                    prevOneIndex = index;
                }
                else
                {
                    int distance = Math.abs(index-prevOneIndex);
                    if(distance > longestDistance)
                    {
                        longestDistance = distance;
                    }
                    prevOneIndex = index;
                }
            }
            n = n/2;
            index++;
        }
        
        return longestDistance;
    }
}
