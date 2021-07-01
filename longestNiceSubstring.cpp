class Solution {
public:
    string longestNiceSubstring(string s) {
        int maxLength = 0;
        string maxSubstring = "";
        for(int i=0;i<s.size();i++)
        {
            string subString = "";
            int upperCaseLetter[26] = {0},lowerCaseLetter[26] = {0};
            
            for(int j=i;j<s.size();j++)
            {
                int flag = 0;
                
                subString += s[j];
                if(isupper(s[j]))
                {
                    upperCaseLetter[s[j]-'A'] = 1;
                }
                else
                {
                    lowerCaseLetter[s[j]-'a'] = 1;
                }
                
                for(int k=0;k<26;k++)
                {
                    if(upperCaseLetter[k] != lowerCaseLetter[k])
                    {
                        flag = 1;
                        break;
                    }
                }
                
                if(flag == 0)
                {
                    if(subString.size() > maxLength)
                    {
                        maxLength = subString.size();
                        maxSubstring = subString;
                    }
                }
            }
        }
        
        return maxSubstring;
    }
};
