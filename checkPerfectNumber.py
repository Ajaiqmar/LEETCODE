# THE PROBLEM STATEMENT IS TO CHECK WHETHER THE GIVEN NUMBER IS A PERFECT NUMBER. A PERFECT NUMBER IS ONE WHOSE SUM OF FACTORS OF THE GIVEN NUMBER
# IS ITSELF.

# MY APPROACH IS TO FIND THE ALL THE FACTORS OF THE GIVEN NUMBER AND FIND THEIR SUM AND CHECK IF IT IS THE SAME AS THE GIGVEN NUMBER.
# BUT INORDER TO REDUCE THE TIME COMPLEXITY, I AM GOING TO REDUCE THE NUMBER OF ITERATIONS BY SQUARE ROOT OF N. SO WHEN AN INTEGER DIVIDES THE GIVEN 
# NUMBER EQUALLY, WE WILL ADD THE DIVISOR AS WELL AS THE QUOTIENT TO THE SUM (EXCEPT IF THE DIVISOR AND QUOTIENT IS UNEQUAL, IF IT IS
# EQUAL, THEN ONLY THE DIVISOR SHOULD BE ADDED).

class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if(num == 1):
            return False
        
        ans = 0
        
        # TRAVERSING THE FROM 1 TO SQRT(N) TO FIND THE SUM OF THE FACTORS.
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

# TIME COMPLEXITY : O(SQRT(N))
# SPACE COMPLEXITY : O(1)
