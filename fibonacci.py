class Solution:
    def fib(self, n: int) -> int:
        if(n <= 0):
            return 0
        else:
            prev2 = 0
            prev1 = 1
            curr = 0
            n -= 1
            
            while(n!=0):
                curr = prev2+prev1
                prev2 = prev1
                prev1 = curr
                n -= 1
            
            return curr
