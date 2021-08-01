# THE PROBLEM STATEMENT IS TO COUNT THE NUMBER OF NEGATIVE VALUES IN A SORTED MATRIX ROW WISE AS WELL AS COLUMN WISE.

# MY APPROACH IS TO START FROM THE TOP-RIGHT END OF THE MATRIX AND START CHECKIJMG WHETHER THE VALUE IS NEGATIVE OR POSITIVE.
# IF IT IS NEGATIVE, WE INCREMENT THE COUNT OF NEGATIVE IN EACH ROW AND DECREMENT THE COLUMN VALUE ELSE WE ADD THE COUNT OF NEGATIVE VALUE TO THE NUMBER OF
# NEGATIVE VALUE AND INCREMENT THE ROW VALUE.

class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
    
        row = 0
        col = len(grid[0])-1
        flag = 0
        noOfNegatives = 0
        countOfNegatives = 0
        
        # TRAVERSING THE MATRIX FROM TOP RIGHT USING THE WHILE LOOP.
        while(row < len(grid)):
            
            if(grid[row][col] < 0 and flag == 0):
                countOfNegatives += 1
                if(col == 0):
                    flag = 1
                else:
                    col -= 1
                continue
            
            row += 1
            noOfNegatives += countOfNegatives
        
        return noOfNegatives
      
# TIME COMPLEXITY : O(N) WHERE N BEING NUMBER OF ELEMENTS IJN EACH ROW.
# SPACE COMPLEXITY : O(1)
