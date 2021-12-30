# THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF DIGITS IN N WHERE N IS THE SMALLEST POSITIVE INTEGER WHICH IS DIVISIBLE BY K AND IT ONLY
# CONTAINS THE DIGIT "1". PS : N MAY NOT FIT IN A 64 - BIT INTEGER. IF THERE IS NO SMALLEST POSITIVE INTEGER THAT IS DIVISIBLE BY K THEN RETURN -1.

# MY APPROACH IS TO FIRST CHECK WHETHER THE NUMBER IS DIVISBLE BY 2 OR 5, IF IT IS RETURN -1, ELSE WITH THE HELP OF WHILE LOOP AND THE MODULO OPERATOR, YOU
# CAN FIND THE LENGTH OF THE SMALLEST POSITIVE INTEGER THAT IS DIVISIBLE BY K.

class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        # CHECKING WHETHER THE GIVEN NUMBER IS DIVISIBLE BY 2 OR 5.
        if(k%2 == 0 or k%5 == 0):
            return -1
        
        ans = 1
        v = 1
        
        # FINDING THE LENGTH OF THE SMALLEST POSITIVE INTEGER THAT IS DIVISIBLE BY K.
        while(v%k != 0):
            v = v%k
            v = (v*10)+1
            ans += 1
        
        return ans
      
# TIME COMPLEXITY : O(K) WHERE K IS THE NUMBER OF DIGITS IN THE SMALLEST POSITIVE INTEGER THAT IS DIVISIBLE BY K.
# SPACE COMPLEXITY : O(1)
