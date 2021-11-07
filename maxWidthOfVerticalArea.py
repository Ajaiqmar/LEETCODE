# THE PROBLEM IS TO RETURN THE WIDEST VERTICAL AREA BETWEEN ANY TWO POINTS ON A 2D GRAPH. THE VERTICAL AREA SHOULDN'T CONTAIN ANY POINTS INSIDE THE AREA AND THE POINTS
# ON THE OUTLINE OF THE AREA AREN'T CONSIDERED TO FALL INSIDE THE AREA.

# MY APPROACH IS TO SORT THE POINTS 2D ARRAY BASED ON X - VALUE, THEN FIND THE LARGEST ABSOLUTE DIFFERENCE BETWEEN ADJACENT TWO POINTS IN THA ARRAY.
# THIS WILL YIELD THE WIDEST VERTICAL AREA.

class Solution:
    def maxWidthOfVerticalArea(self, points: List[List[int]]) -> int:
        # SORTING THE GIVEN POINTS ARRAY
        points = sorted(points,key = lambda x : x[0])
        ans = 0
        
        # FINDING THE WIDEST VERTICAL AREA.
        for i in range(len(points)-1):
            d = abs(points[i][0]-points[i+1][0])
            if(d > ans):
                ans = d
        
        return ans
      
# TIME COMPLEXITY : O(N LOG N)
# SPACE COMPLEXITY : O(1)
