class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        d = {}
        
        for i in s:
            if i not in d:
                d[i] = 1
            else:
                d[i] += 1
        
        for i in t:
            if i not in d:
                return i
            else:
                d[i] -= 1
                if(d[i] == -1):
                    return i
