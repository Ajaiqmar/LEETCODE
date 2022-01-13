# THE PROBLEM STATEMENT IS TO RETURN THE MINIMUM NUMBER OF SHOTS TO BE TAKEN TO POP ALL THE BALLOONS IN THE GIVEN TABLE. THE POINTS
# ARRAY CONTAINS THE [POINT WHERE THE BALLOON STARTS IN X-AXIS, POINT WHERE THE BALLOON ENDS IN X-AXIS], IN SIMPLE WORDS, THE POINTS 2D ARRAY CONTAINS
# DIAMETER OF THE BALLOON IN TERMS X - AXIS.

# MY APPORACH IS TO SORT THE POINTS ARRAY IN TERMS OF POINTS[I][0], NOW WE HAVE TO TRAVERSE THE ARRAY AND WHILE TRAVERSING WE HAVE KEEP IN CHECK
# OF THE X AND Y WHICH IS THE MINIMUM DIAMETER BETWEEN X AND Y WITHIN A SUBSEGMENT OF BALLOONS, IF THE CURRENT POINTS[I][0] IS NOT WITHIN THE
# MINIMUM DIAMETER, THEN A NEW SUBSEGMENT IS FORMED, SO INCREMENT THE ANSWER BY ONE. FINALLY, RETURN THE ANS VARIABLE.

class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        # SORTING THE POINTS ARRAY 
        points = sorted(points,key = lambda x : x[0])
        x = points[0][0]
        y = points[0][1]
        ans = 1
        
        # TRAVERSING THE POINTS ARRAY
        for i in range(1,len(points)):
            if(points[i][0] >= x and points[i][0] <= y):
                x = min(points[i][0],x)
                y = min(points[i][1],y)
                continue
            else:
                ans += 1
                x = points[i][0]
                y = points[i][1]
        
        return ans
      
# TIME COMPLEXITY : O(N LOG N)
# SPACE COMPLEXITY : O(1)
