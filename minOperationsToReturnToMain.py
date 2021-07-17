class Solution:
    def minOperations(self, logs: List[str]) -> int:
        minOperations = 0
        
        for i in logs:
            if(i == "../"):
                if(minOperations > 0):
                    minOperations -= 1
            elif(i == "./"):
                continue
            else:
                minOperations += 1
        
        return minOperations
