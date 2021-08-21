# THE PROBLEM STATEMENT IS TO CONVERT AND RETURN INTEGERS FROM BASE 10 TO BASE 7.

# MY APPROACH IS TO DIVIDE THE INTEGER UNTIL IT IS GREATER THAN ZERO, AND AT EACH TRAVERSAL FIND THE REMAINDER AND ADD THAT VALUE TO THE ANS.

class Solution:
    def convertToBase7(self, num: int) -> str:
        val = abs(num)
        ans = ""
        
        # CONVERTING THE INTEGER FROM BASE 10 TO BASE 7
        while(val!=0):
            ans = str(val%7) + ans
            val = val//7
        
        if(num < 0):
            ans = "-"+ans
        elif(num == 0):
            ans = "0"
        
        return ans
    
# TIME COMPLEXITY : O(LOG N)
#SPACE COMPLEXITY : O(1)
