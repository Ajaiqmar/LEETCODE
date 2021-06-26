class Solution 
{
public:
    string reverseStr(string s, int k) 
    {
        for(int i=0;i<s.size();i+=(2*k))
        {
            int st = i,en = i+k-1;
            if(en>=s.size())
            {
                en = s.size()-1;
            }
            
            while(st<en)
            {
                char temp = s[st];
                s[st] = s[en];
                s[en] = temp;
                st += 1;
                en -= 1;
            }
        
        }
        return s;
    }
};
