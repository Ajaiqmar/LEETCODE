class Solution:
    def minOperations(self, s: str) -> int:
        countOf01Operations = 0
        countOf10Operations = 0
        
        for i in range(len(s)):
            if(i%2 == 0):
                if(s[i] == '1'):
                    countOf01Operations += 1
                elif(s[i] == '0'):
                    countOf10Operations += 1
            else:
                if(s[i] == '0'):
                    countOf01Operations += 1
                elif(s[i] == '1'):
                    countOf10Operations += 1
        
        
        return min(countOf01Operations,countOf10Operations)
