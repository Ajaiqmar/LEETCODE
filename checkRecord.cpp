class Solution {
public:
    bool checkRecord(string s) {
        bool ans = true;
        
        int countOfAbsent = 0, countOfLate = 0;
        for(int i=0;i<s.size();i++)
        {
            if(s[i] == 'L')
            {
                countOfLate += 1;
            }
            else
            {
                countOfLate = 0;
            }
            
            if(s[i] == 'A')
            {
                countOfAbsent += 1;
            }
            
            if(countOfLate >= 3 || countOfAbsent >= 2)
            {
                ans = false;
                break;
            }
        }
        
        return ans;
    }
};
