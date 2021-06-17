# APPROACH - 1
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
        
  
# APPROACH - 2

class Solution:
    def canWinNim(self, n: int) -> bool:
        return !(n%4==0)
