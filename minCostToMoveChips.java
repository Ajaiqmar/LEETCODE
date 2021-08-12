// THE PROBLEM STATEMENT IS RETURN THE MINIMUM COST REQUIRED TO MOVE ALL THE CHIPS TO A SINGLE POSITION.
// THE POSITION PROVIDES THE POSITION OF THE I-TH COINT.

// WE COULD MOVE FROM I TO I+2 OR I-2 POSITION FOR COST = 0 ELSE WE COULD MOVE FROM I TO I-1 OR I+1 POSITION FOR COST = 1.

// MY APPROACH IS TO COUNT THE NUMBER OF EVEN POSITIONS AND COUNT THE NUMBER OF ODD POSTION AND RETURN THE MINIMUM BETWEEN THEM.
// BECAUSE WE COULD MOVE ALL THE ODD TO POSITION 1 AND ALL THE EVEN TO POSITION 0 WITH 0 COST, THEN COST TO MOVE FROM ODD TO EVEN OR EVEN TO ODD IS ONE.
// HENCE, THIS WOULD BE THE EFFICIENT LOGIC.

class Solution {
    public int minCostToMoveChips(int[] position) {
        int countOfEven = 0,countOfOdd = 0;
        
        // TRAVERSING THE ARRAY TO COUNT THE NUMBER OF EVEN AND ODD POSITIONS.
        for(int i=0;i<position.length;i++)
        {
            if(position[i]%2 == 0)
            {
                countOfEven += 1;
            }
            else
            {
                countOfOdd += 1;
            }
        }
        
        return Math.min(countOfEven,countOfOdd);
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
