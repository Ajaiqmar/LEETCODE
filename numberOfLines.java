class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int countOfLines = 1;
        int currLinePixelCount = 0;
        
        for(int i=0;i<s.length();i++)
        {
            int ind = s.charAt(i)-'a';
            int width = widths[ind];
            
            if(currLinePixelCount+width > 100)
            {
                currLinePixelCount = width;
                countOfLines++;
            }
            else
            {
                currLinePixelCount += width;
            }
        }
        
        int[] ans = {countOfLines,currLinePixelCount};
        
        return ans;
    }
}
