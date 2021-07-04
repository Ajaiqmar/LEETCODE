class Solution:
    def findLHS(self, nums: List[int]) -> int:
        d = {}
        maxLength = 0
        
        for i in nums:
            if i not in d:
                d[i] = 1
            else:
                d[i] += 1
            
            if (i+1 in d and maxLength < (d[i]+d[i+1])):
                maxLength = d[i]+d[i+1]
                    
            if (i-1 in d and maxLength < (d[i]+d[i-1])):
                maxLength = d[i]+d[i-1]
            
        
        return maxLength
