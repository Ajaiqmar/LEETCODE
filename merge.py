# THE PROBLEM STATEMENT IS TO MERGE ALL THE OVERLAPPING INTERVALS GIVEN AN ARRAY OF INTERVALS WHERE INTERVALS[I] = [STARTI,ENDI].

# MY APPROACH IS TO SORT THE ARRAY BASED ON THE STARTI VALUE,AND THEN MERGE VALUES IF THE PREVIOUS INTERVALS ENDI VALUE IS GREATER THAN OR EQUAL TO 
# CURRENT INTERVALS STARTI VALUE. FINALLY, RETURN THE ARRAY.

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # SORTING THE GIVEN ARRAY OF INTERVALS.
        intervals = sorted(intervals,key = lambda x : x[0])
        ans = [intervals[0]]
        
        # TRAVERSING AND MERGING THE GIVEN ARRAY OF INTERVALS.
        for i in range(1,len(intervals)):
            
            if(intervals[i][0] >= ans[-1][0] and intervals[i][0] <= ans[-1][1]):
                ans[-1][1] = max(ans[-1][1],intervals[i][1])
            else:
                ans.append(intervals[i])
        
        return ans
      
# TIME COMPLEXITY : O(N LOG N)
# SPACE COMPLEXITY : O(M) WHERE M IS THE NUMBER OF INTERVALS.
