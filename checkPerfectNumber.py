class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if(num == 1):
            return False
        
        ans = 0
        
        for i in range(1,math.floor(math.sqrt(num))+1):
            if(num%i == 0):
                divisor1 = i
                divisor2 = num//i
                
                if(divisor1 == 1 or divisor1 == divisor2):
                    ans += divisor1
                else:
                    ans += divisor1+divisor2
        
        if(ans == num):
            return True
        else:
            return False
