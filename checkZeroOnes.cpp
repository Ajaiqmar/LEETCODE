class Solution {
public:
    bool checkZeroOnes(string s) {
        int longestCountOfOnes = 0,longestCountOfZeros = 0,ones = 0,zeros = 0;
        
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
