class Solution:
    def convertToBase7(self, num: int) -> str:
        val = abs(num)
        ans = ""
        
        while(val!=0):
            ans = str(val%7) + ans
            val = val//7
        
        if(num < 0):
            ans = "-"+ans
        elif(num == 0):
            ans = "0"
        
        return ans
