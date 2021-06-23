class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        for i in range(len(s)-1):
            if(len(s)%(i+1) == 0):
                st = s[:i+1]
                v = len(s)//(i+1)
                
                if((st*v) == s):
                    return True
        
        return False
