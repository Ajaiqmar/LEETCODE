# THE PROBLEM STATEMENT IS TO FIND THE SUM OF ALL THE ODD LENGTH SUB-ARRAYS OF THE GIVEN ARRAY.

# MY APPROACH IS TO USE A COMBINATION OF PREFIX ARRAY AND SLIDING WINDOW TECHNIQUE. FIRST, FIND THE PREFIX SUM OF THE GIVEN ARRAY. THEN USE THE SLIDING WINDOW TECHNIQUE
# TO TRAVERSE THE PREFIX SUM AND FIND THE SUM OF ODD LENGTH SUB-ARRAYS. THIS APPROACH REDUCES THE TIME COMPLEXITY FROM O(N*N*N) TO O(N*N).

class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        
        # FINDING THE PREFIX SUM OF THE GIVEN ARRAY. 
        for i in range(1,len(arr)):
            arr[i] += arr[i-1]
        
        ans = 0
        for i in range(1,len(arr)+1,2):
            ans += arr[i-1]
            lind = 0
            rind = i
            
            # PERFORMING THE SLIDING WINDOW TECHNIQUE.
            while(rind < len(arr)):
                ans += (arr[rind]-arr[lind])
                rind += 1
                lind += 1
        
        return ans
      
# TIME COMPLEXITY : O(N*N)
# SPACE COMPLEXITY : O(1)
        
  
# EFFECTIVE APPROACH IS TO USE A MATHEMATICAL APPROACH, BECAUSE WHEN YOU LOOK AT COUNT OF EACH INTEGER REPEATED FROM THE GIVEN ARRAY TO GET THE FINAL SUM,
# IT FORMS A LOGIC.

# I.E. IF N = 1, THEN THE LOGIC IS [1]
#      IF N = 2, THEN THE LOGIC IS [1,1]
#      IF N = 3, THEN THE LOGIC IS [2,2,2]
#      IF N = 4, THEN THE LOGIC IS [2,3,3,2]
#      IF N = 5, THEN THE LOGIC IS [3,4,5,4,3]
#      IF N = 6, THEN THE LOGIC IS [3,5,6,6,5,3]

# FROM THIS LOGIC WE COULD DERIVE A FORMULAE, THEN THE TIME COMPLEXITY WOULD FURTHER BE DECREASED TO O(N).
