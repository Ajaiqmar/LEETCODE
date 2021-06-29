class Solution {
public:
    int countGoodSubstrings(string s) {
        int ans = 0;
        if(s.size() < 3)
        {
            return ans;
        }
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
