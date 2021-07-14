class Solution:
    def isGood(self,val):
        flag = 0
        
        while(val != 0):
            if(val%10 == 2 or val%10 == 5 or val%10 == 6 or val%10 == 9):
                flag = 1
            if(val%10 == 3 or val%10 == 4 or val%10 == 7):
                flag = 0
                break
            val = val//10
        
        if(flag == 1):
            return 1
        
        return 0
            
    def rotatedDigits(self, n: int) -> int:
        ans = 0
        
        for i in range(1,n+1):
            if(self.isGood(i)):
                ans += 1
        
        return ans
