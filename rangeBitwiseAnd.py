# THE PROBLEM STATEMENT IS TO RETURN BITWISE AND OF ALL THE NUMBERS IN THE INCLUSIVE RANGE OF LEFT TO RIGHT.

# MY APPROACH IS SINCE THE CONSTRAINTS ARE PRETTY HIGH, WE MAY ENCOUNTER TIME LIMITED EXCEEDED ERROR, SO AN EASY WAY TO ESCAPE TLE IS TO CHECK THE NUMBER OF BITS
# IN THE LEFT AND RIGHT VALUE, IF THE NUMBER OF BITS IN THE LEFT VALUE IS LESSER THAN THE RIGHT VALUE, THEN WE WILL RETURN ZERO, BECAUSE OF THE FACT THAT
# N&(N-1) == 0 WHERE N IS A POWER OF 2. IF IS FAILS THE CONDITION, THEN WE TRAVERSE THE RANGE AND FIND THE BITWISE AND OF ALL THE NUMBERS IN THE RANGE.

class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        if(len(bin(left)) < len(bin(right))):
            return 0
        
        ans = left
        
        # TRAVERSING THE INCLUSIVE RANGE FROM LEFT TO RIGHT.
        for i in range(left+1,right+1):
            ans = ans&i
            
            if(ans == 0):
                return 0
        
        return ans

# TIME COMPLEXITY : O(N) WHERE N IS THE RANGE FROM LEFT TO RIGHT
# SPACE COMPLEXITY : O(1)
