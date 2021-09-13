//  THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF SQUARES THAT CAN BE OBTAINED OF MAX LENGTH FROM THE GIVEN RECTANGLES ARRAY.
// THE RECTANGLES ARRAY CONATINS THE LENGTH AND BREADTH OF A I-TH RECTANGLE AT THE I-TH INDEX. WE CAN CUT A SQUARE FROM IT OF LENGTH = MIN(LENGTH,BREADTH).

// MY APPROACH IS TO TRAVERSE THE RECTANGLES ARRAY WHILE TRAVERSING CHECK FOR THE LENGTH OF SQUARE THAT CAN BE OBTAINED FROM THAT RECTANGLE,
// THEN CHECK IF IT IS THE MAXIMUM LENGTH OF SQUARE THAT IS OBTAINED, ALSO KEEP IN CHECK OF THE NUMBER OF NAX LENGTH SQUARES THAT IS OBTAINED FROM THE RECTANGLES.

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLength = 0,maxLengthCount = 0; 
        
        // TRAVERSING THE RECTANGLES ARRAY.
        for(int i=0;i<rectangles.length;i++)
        {
            int lengthOfSquare = Math.min(rectangles[i][0],rectangles[i][1]);
            
            if(lengthOfSquare > maxLength)
            {
                maxLength = lengthOfSquare;
                maxLengthCount = 1;
            }
            else if(maxLength == lengthOfSquare)
            {
                maxLengthCount++;
            }
        }
        
        return maxLengthCount;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
