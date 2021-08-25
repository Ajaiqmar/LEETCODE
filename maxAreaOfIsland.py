# THE PROBLEM STATEMENT IS TO RETURN THE MAXIMUM AREA OCCUPIED BY AN ISLAND. AN ISLAND IS REPRESENTED BY THE NUMBER OF ONES THAT ARE ATTACHED TOGETHER
# IN ALL THE FOUR DIRECTIONS (TOP,LEFT,DOWN AND RIGHT) IN THE GIVEN BINARY MATRIX. THE AREA OF THE ISLAND IS THE NUMBER OF ONES IN THAT GROUP.

# MY APPROACH IS TO TRAVERSE THE GRID AND WHENEVER A ONE IS ENCOUNTERED DO A DFS TRAVERSAL OF THE GRID TO CALCULATE THE AREA OF THE GIVEN GROUP. 
# THEN CHECK IF IT IS THE MAX AREA AMONG THE GROUPS FOUND IN THE GRID.

class Solution:
    # FUNCTION TO DO A DFS TRAVERSAL.
    def dfs(self,r,c,area):
        if(r >= 0 and r < len(self.grid) and c >= 0 and c < len(self.grid[0])):
            self.grid[r][c] = 0
            area += 1
            
            if(r < (len(self.grid)-1) and self.grid[r+1][c] == 1):
                area = self.dfs(r+1,c,area)
                
            if(r >= 0 and self.grid[r-1][c] == 1):
                area = self.dfs(r-1,c,area)
            
            if(c >= 0 and self.grid[r][c-1] == 1):
                area = self.dfs(r,c-1,area)
                
            if(c < (len(self.grid[0])-1) and self.grid[r][c+1] == 1):
                area = self.dfs(r,c+1,area)
            
        return area
            
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        self.grid = grid
        
        maxArea = 0
        
        # TRAVERSING THE GRID.
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(self.grid[i][j] == 1):
                    area = self.dfs(i,j,0)
                    
                    if(area > maxArea):
                        maxArea = area
        
        return maxArea
      
# TIME COMPLEXITY : O(N*M)
# SPACE COMPLEXITY : O(N*M)
