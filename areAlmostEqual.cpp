class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        int countOfCharacters1[26]={0},countOfCharacters2[26]={0};
        
        for(int i=0;i<s1.size();i++)
        {
            countOfCharacters1[s1[i]-'a']++;
            countOfCharacters2[s2[i]-'a']++;
        }
        
        for(int i=0;i<26;i++)
        {
            if(countOfCharacters1[i]!=countOfCharacters2[i])
            {
                return false;
            }
        }
        
        int countOfMisplacedCharacters = 0;
        
        for(int i=0;i<s1.size();i++)
        {
            if(s1[i]!=s2[i])
            {
                countOfMisplacedCharacters++;
            }
        }
        
        if(countOfMisplacedCharacters == 0 || countOfMisplacedCharacters == 2)
        {
            return true;
        }
        
        return false;
    }
};
