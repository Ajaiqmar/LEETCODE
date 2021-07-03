class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLength = 0,maxLengthCount = 0; 
        
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
