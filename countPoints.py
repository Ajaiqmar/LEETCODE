# THE PROBLEM STATEMENT IS TO FIND THE NUMBER OF RODS THAT CONTAINS ALL THE THREE RINGS. THERE ARE N RINGS AND EACH RING IS EITHER RED, GREEN OR BLUE. THERE WILL BE A
# TOTAL OF TEN RODS NUMBERED FROM 0 TO 9. YOU ARE GIVEN A STRING OF LENGTN 2*N, EVERY TWO CHARCTERS IN THE STRING FORM A COLOR-POSITION PAIR THAT IS
# USED TO DESCRIBE THE POSITION OF THE RINGS.

# MY APPROACH IS TO USE DICTIONARY TO STORE THE WHICH RODS NUMBERED FROM 0 TO 9 CONTAINS ALL THE THREE RINGS AND THEN RETURN THE COUNT OF NUMBER OF RODS.

class Solution:
    def countPoints(self, rings: str) -> int:
        rods = {}
        ans = 0
        
        # INITIALISING THE DICTIONARY.
        for i in range(10):
            rods[i] = [0,0,0]
        
        # TRAVERSING THE STRING.
        for i in range(0,len(rings),2):
            rodColor = rings[i]
            rod = int(rings[i+1])
            
            if(rodColor == 'R'):
                rods[rod][0] = 1
            elif(rodColor == 'G'):
                rods[rod][1] = 1
            elif(rodColor == 'B'):
                rods[rod][2] = 1
            
        for i in range(10):
            if(sum(rods[i]) == 3):
                ans += 1
        
        return ans
      
# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(1) SINCE THE NUMBER OF RODS DOEN'T GROW LINEARLY.
