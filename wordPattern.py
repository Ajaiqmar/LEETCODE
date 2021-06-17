class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        s = s.split()
        
        if(len(pattern)!=len(s)):
            return False
        
        dp = {}
        ds = {}
        
        for i in range(len(s)):
            if pattern[i] in dp and s[i] in ds and dp[pattern[i]]!=ds[s[i]]:
                return False
            elif pattern[i] in dp and s[i] not in ds:
                return False
            elif pattern[i] not in dp and s[i] in ds:
                return False
            else:
                dp[pattern[i]] = i
                ds[s[i]] = i
        
        return True
