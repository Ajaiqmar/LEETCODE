class Solution {
public:
    int hammingDistance(int x, int y) {
        int z = x^y,ans = 0;
        
        while(z!=0)
        {
            if((z%2)==1)
            {
                ans += 1;
            }
            z = z/2;
        }
        
        return ans;
    }
};
