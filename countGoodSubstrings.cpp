// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF GODD SUB-STRINGS OF LENGTH 3. A STRING IS SAID TO BE GOOD, IF ALL THE CHARACTERS ARE UNIQUE.

// MY APPROACH IS TO TRAVERSE THE STRING FROM INDEX 0 TO N-3, WHILE TRAVERSING AT EACH ITERATION CHECK IF THE CURRENT AND THE NEXT TWO CHARACTERS
// ARE SAME, IF IT ISN'T INCREMENT THE ASNWER VALUE BY ONE.

class Solution {
public:
    int countGoodSubstrings(string s) {
        int ans = 0;
        if(s.size() < 3)
        {
            return ans;
        }
        
        // TRAVERSING THE STRING TO FIND THE NUMBER OF GOOD SUBSTRINGS OF LENGTH 3.
        for(int i=0;i<s.size()-2;i++)
        {
            int alphaTable[26] = {0},flag = 0;
            
            for(int j=i;j<i+3;j++)
            {
                alphaTable[s[j]-'a'] += 1;
                
                if(alphaTable[s[j]-'a'] > 1)
                {
                    flag = 1;
                    break;
                }
            }
            
            if(flag == 0)
            {
                ans += 1;
            }
        }
        
        return ans;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
