# DIVIDE AND CONQUER APPROACH

class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        if(len(s) < 2):
            return ""
        letter = set()
        
        for i in s:
            letter.add(i)
        
        for i in range(len(s)):
            if s[i].upper() in letter and s[i].lower() in letter:
                continue
            sub1 = self.longestNiceSubstring(s[:i])
            sub2 = self.longestNiceSubstring(s[i+1:])
            
            if(len(sub1) >= len(sub2)):
                return sub1
            else:
                return sub2
        
        return s
