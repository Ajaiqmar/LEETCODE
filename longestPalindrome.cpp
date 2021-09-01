// THE PROBLEM STATEMENT IS TO RETURN THE LONGEST PALINDROMIC SUBSTRING.

// I HAVE ALREADY DISCUSSED AN APPROACH FOR THIS PROBLEM, THIS IS MY SECOND APPROACH, WHICH IS TO USE DYNAMIC PROGRAMMING.
// SO, IN THIS APPROACH, WE WILL HAVE A TWO DIMENSIONAL SQUARE MATRIX OF LENGTH N WHERE N IS THE LENGTH OF THE GIVEN STRING. IN THIS, SQUARE MATRIX,
// MARK ALL THE DIAGONAL ELEMENTS AS TRUE AND THE REST OF WHICH AS SMALL. THE REASON WE ARE DOING THIS IS TO REPRESENT THAT THE ALL THE CHARACTERS INSIDE THE STRING
// ARE PALINDROMES. NOW, WE HAVE TO CONSIDER ALL THE CHARACTER PAIRS AND CHECK IF THEY ARE EQUAL AND THEIR PREVIOUS CHARACTERS ARE EQUAL USING TWO POINTER TECHNIQUE.
// IF IT IS THEN CHECK IF ITS LENGTH IS GREATER THAN THE MAXLENGTH AND RECORD ITS STARTING INDEX AS WELL. MAKE SURE TO MARK THE CURRENT CHARACTERS AS WELL IN THE BOOLEAN
// MATRIX.

class Solution 
{
public:
    string longestPalindrome(string s) 
    {
        bool dp[s.length()][s.length()];
        
        // INITIALISING THE BOOLEAN MATRIX.
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<s.length();j++)
            {
                if(i == j)
                {
                    dp[i][j] = true;
                }
                else
                {
                    dp[i][j] = false;
                }
            }
        }
        
        int startingIndex = -1,maxLength = 0;
        
        // CONSIDERING ALL THE PAIRS OF CHARACTERS.
        for(int i=(s.length()-1);i>=0;i--)
        {
            for(int j=i+1;j<s.length();j++)
            {
                if(s[i] == s[j])
                {
                    if((j-i) == 1 || dp[i+1][j-1])
                    {
                        int len = (j-i)+1;
                        if(len >= maxLength)
                        {
                            maxLength = len;
                            startingIndex = i;
                        }
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        if(maxLength == 0)
        {
            return s.substr(0,1);
        }
        
        return s.substr(startingIndex,maxLength);
    }
};

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N*N)
