# THE PROBLEM STATEMENT IS TO CHECK IF THE PLAYER HAS A CHANCE TO WIN THE NIM GAME, IF BOTH THE PLAYERS PLAYED OPTIMALLY.
# THE RULES OF NIM GAME ARE: N NUMBER OF STONES ARE GIVEN, ON EACH TURN, THE PLAYER CAN TAKE FROM 1 TO 3 STONES. THE PLAYER WHO TAKES THE 
# LAST REMAINING STONES IS CONSIDERED TO BE THE WINNER.

# APPROACH - 1
# MY APPROACH IS TO CHECK FOR EVERY POSIBLE MOVES AND STORE IN THE ARRAY ARR. THEN CHECK FOR ADDITIONAL MOVES THAT HAS BEEN LEFT OUT.
# THEN CHECK THE NUMBER OF ODD MOVES AND EVEN MOVES IN THE ARRAY ARR. IF ODD MOVES IS GREATER THEN THERE IS A POSSIBILITY THAT OUR PLAYER CAN WIN ELSE THERE ISN'T ONE.

class Solution:
    def canWinNim(self, n: int) -> bool:
        if(n<=3):
            return True
        
        arr = [n,n//2,n//3,(n//3)*2,(n//4)*2,(n//5)*2,(n//6)*3,(n//6)*3]
        
        if(n%2!=0):
            arr[1] += 1
        
        if(n%3!=0):
            arr[2] += 1
            arr[3] += 1
        
        if(n%4!=0):
            arr[4] += 1
        
        if(n%5!=0):
            if(n%5==4):
                arr[5] += 4
            else:
                arr[5] += 1
        
        if(n%6!=0):
            if(n%6==4):
                arr[6] += 4
                arr[7] += 4
            elif(n%6<=3):
                arr[6] += 1
                arr[7] += 1
            else:
                arr[6] += 5
                arr[7] += 2
        
        e = 0
        o = 0
        
        for i in arr:
            if(i%2==0):
                e += 1
            else:
                o += 1
        
        if(e>o):
            return False
        else:
            return True
        
# TIME COMPLEXITY : O(1) SINCE THE LENGTH OF THE ARRAY DOESN'T GROW LINEARLY ACCORDING TO THE INPUT.
# SPACE COMPLEXITY : O(1)
        
# APPROACH - 2
# TURNS OUT IT IS A SILLY BRAIN TEASER QUESTION, SO IF THE N IS DIVISIBLE BY 4 THEN OUR PLAYER HAS NO CHANCE ELSE HE HAS A CHANCE.
# SO, STRAIGHT AWAY JUMPING INTO ALGORITHM JUST GO THROUGH THE QUESTION ONCE MORE TO FIND WHETHER THE QUESTION HAS SOME MATHEMATICAL LOGIC IN IT.

class Solution:
    def canWinNim(self, n: int) -> bool:
        return !(n%4==0)

# TIME COMPLEXITY : O(1) SINCE THE LENGTH OF THE ARRAY DOESN'T GROW LINEARLY ACCORDING TO THE INPUT.
# SPACE COMPLEXITY : O(1)
