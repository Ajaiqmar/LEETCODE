class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        s = math.floor(num**(1/2))
        
        if(s*s == num):
            return True
        else:
            return False
        
