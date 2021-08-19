# THE PROBLEM STATEMENT IS TO RETURN AN ARRAY OF LENGTH N WHOSE SUM IS ZERO AND HAS UNIQUE INTEGERS.

# MY APPROACH IS TO START TRAVERSING FROM -(N//2) TO (N//2) IF N IS ODD ELSE IF N IS EVEN WE LEAVE OUT THE ZERO.
# THIS WILL YIELD AN ARRAY OF LENGTH N AND HAS UNIQUE INTEGERS ALSO THEIR SUM IS EQUAL TO ZERO. 

class Solution:
    def sumZero(self, n: int) -> List[int]:
        ans = []
        
        # CHECKING WHETHER N IS EVEN OR ODD. 
        if(n%2 == 0):
            # TRAVERSING FROM -(N//2) TO (N//2)
            for i in range(-(n//2),(n//2)+1):
                if(i != 0):
                    ans.append(i)
        else:
            # TRAVERSING FROM -(N//2) TO (N//2)
            for i in range(-(n//2),(n//2)+1):
                ans.append(i)
        
        return ans
      
# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(N)
