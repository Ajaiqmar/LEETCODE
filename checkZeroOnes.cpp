// THE PROBLEM STATEMENT IS TO CHECK IF THE LONGEST CONTIGOUS SEGMENT OF ONES IS STRICTLY GREATER THAN LONGEST CONTIGOUS SEGMENT OF ZEROS. THE GIVEN STRING WILL
// CONTAIN ONLY ONES AND ZEROS.

// MY APPROACH IS TO USE MODIFIED KADANE ALGORITHM AND CHECK FOR LENGEST CONTIGOUS SEGMENT OF ZEROS AND ONES. THEN COMPARE THEM BOTH AND RETURN THE ANSWER.
// KADANE ALGORITHM IS TO TRAVERSE THE STRING AND KEEP COUNTER FOR COUNT OF ONES AND ZEROS AND ALSO THE LONGEST COUNT FOR ONES AND ZEROS.
// IF THE GIVEN CHARACTER IS ONE INCREMENT THE COUNT OF ONES ELSE INITIALISE IT TO THE DEFAULT VALUE. REPEAT THE SAME FOR ZEROS AS WELL.
// AT EACH ITERATION, ALSO CHECK IF THE COUNT OF ONES AND ZEROS IS GREATER THAN THE LONGEST COUNT OF ZEROS AND ONES.

class Solution {
public:
    bool checkZeroOnes(string s) {
        int longestCountOfOnes = 0,longestCountOfZeros = 0,ones = 0,zeros = 0;
        
        // TRAVERSING THE STRING AND CHECKING FOR LONGEST CONTIGOUS SEGMENTS OF ONES AND ZEROS.
        for(int i=0;i<s.size();i++)
        {
            if(s[i] == '1')
            {
                ones += 1;
            }
            else
            {
                ones = 0;
            }
            
            if(s[i] == '0')
            {
                zeros += 1;
            }
            else
            {
                zeros = 0;
            }
            
            if(ones > longestCountOfOnes)
            {
                longestCountOfOnes = ones;
            }
            
            if(zeros > longestCountOfZeros)
            {
                longestCountOfZeros = zeros;
            }
        }
        
        if(longestCountOfOnes > longestCountOfZeros)
        {
            return true;
        }
        return false;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
