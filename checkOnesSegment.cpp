// THE PROBLEM STATEMENT IS TO CHECK WHETHER THE GIVEN STRING CONTAINS ATMOST ONE CONTIGOUS SEGMENT OF ONES. THE GIVEN STRING WILL ONLY CONTAIN '1' OR '0'.

// MY APPROACH IS TO FIND THE LENGTH OF LONGEST CONTIGOUS SEGMENT OF ONES USING THE MODIFIED KADANE ALGORITHM. THEN CHECK IF THE COUNT OF ONES IS EQUAL 
// TO THE LENGTH OF LONGEST CONTIGOUS SEGMENT OF ONES.

class Solution {
public:
    bool checkOnesSegment(string s) {
        int longestContigousSegment = 0,countOfOnes = 0,countOfSegments = 0;
        
        // TRAVERSING THE ARRAY TO FIND THE LENGTH OF THE LONGEST CONTIGOUS SEGMENT OF ONES.
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

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
