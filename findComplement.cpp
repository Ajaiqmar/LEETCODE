class Solution {
public:
    int findComplement(int num) {
        long long int v = 1;
        int ans = 0;
        
        while(num!=0)
        {
            if(num%2 == 0)
            {
                ans += v;
            }
            v *= 2;
            num /= 2;
        }
        
        return ans;
    }
};
