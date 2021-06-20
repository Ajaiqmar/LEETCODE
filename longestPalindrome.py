class Solution:
    def longestPalindrome(self, s: str) -> int:
        d = {}
        odd = 0
        ans = 0
        
        for i in s:
            if i not in d:
                d[i] = 1
            else:
                d[i] += 1
        
        for i in d:
            if(d[i]%2!=0):
                odd = 1
                ans += d[i]-1
            else:
                ans += d[i]
        
        if(odd==1):
            ans += 1
        
        return ans
