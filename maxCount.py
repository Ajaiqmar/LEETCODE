class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        minRow,minCol = m,n
        
        for i in ops:
            if(i[0]<minRow):
                minRow = i[0]
            if(i[1]<minCol):
                minCol = i[1]
            
        return minRow*minCol
