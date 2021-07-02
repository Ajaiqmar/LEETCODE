class Solution {
public:
    bool checkOnesSegment(string s) {
        int longestContigousSegment = 0,countOfOnes = 0,countOfSegments = 0;
        
        for(int i=0;i<s.size();i++)
        {
            if(s[i] == '1')
            {
                countOfSegments++;
                countOfOnes++;
            }
            else if(s[i] == '0')
            {
                countOfSegments = 0;
            }
            
            if(countOfSegments > longestContigousSegment)
            {
                longestContigousSegment = countOfSegments;
            }
        }
        
        return longestContigousSegment==countOfOnes;
    }
};
