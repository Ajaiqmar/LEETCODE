// THE PROBLEM STATEMENT IS TO PRINT THE LONGEST DISTANCE BETWEEN TWO SET BITS IN THE BINARY REPRESENTATION OF THE GIVEN DECIMAL VALUE.

// MY APPROACH IS TO KEEP THE INDEX OF THE PREVIOUS SET BIT THAT HAS BEEN VISITED AND WHEN A SET BIT IS ENCOUNTERED FIND THE DISTANCE BETWEEN THE PREVIOUS AND 
// THE CURRENT SET BIT. AND THEN CHECK IF THE DISTANCE IS GREATER THAN LONGEST DISTANCE VALUE.

class Solution {
    public int binaryGap(int n) {
        int longestDistance = 0,index = 0,prevOneIndex = -1;
        
        // FINDING THE BINARY REPRESENTATION OF THE GIVEN DECIMAL VALUE.
        while(n != 0)
        {
            // CHECKING IF IT IS A SET BIT
            if(n%2 == 1)
            {
                if(prevOneIndex == -1)
                {
                    prevOneIndex = index;
                }
                else
                {
                    // FINDING THE DISTANCE BETWEEN THE PREVIOUS SET BIT INDEX AND THE CURRENT SET BIT INDEX.
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

// TIME COMPLEXITY : O(LOG N)
// SPACE COMPLEXITY : O(1)
