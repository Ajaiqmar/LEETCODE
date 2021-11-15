// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF 4-DIRECTIONAL WALKS FROM THE STARTING SQUARE TO THE ENDING SQUARE, THAT WALK OVER 
// EVERY NON-OBSTACLE SQUARE EXACTLY ONCE. GIVEN A 2D - ARRAY WHICH CONTAINS ONLY THE VALUES [2,1,0,-1] WHERE 2 REPRSENTS THE FINISHING POINT, 1 REPRESENTS
// THE STARTING POINT (THERE WILL BE ONLY ONE STARTING AND ENDING POINT), 0 RESPRESENTS THE NON-OBSTACLE SQUARE, AND -1 REPRESENTS THE OBSTACLE.

// MY APPROACH IS TO FIRST COUNT THE NUMBER OF NON-OBSTACLE SQUARE, THEN DO A DFS TRAVERSAL FROM THE STARTING POINT TO THE ENDING POINT, WHILE TRAVERSING
// COUNT THE NUMBER OF ZEROS FROM THE STARTING POINT TO THE ENDING POINT. AFTER REACHING THE END POINT, CHECK IF THE NUMBER OF ZEROS IN THE PATH IS SAME
// AS THE TOTAL NUMBER OF NON-OBSTACLE SQUARES. IF IT IS THE SAME, INCREMENT THE VALUE OF ANS. FINALLY, RETURN THE ANS VARIABLE.

class Solution 
{
    int ans = 0;
    public void explorePaths(int[][] grid,int r,int c,int es,int tes)
    {
        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
        {
            if(grid[r][c] == 2)
            {
                if(es == tes)
                {
                    ans += 1;
                }
                return ;
            }
            else if(grid[r][c] == 1)
            {
                grid[r][c] = -1;
                explorePaths(grid,r+1,c,es,tes);
                explorePaths(grid,r-1,c,es,tes);
                explorePaths(grid,r,c+1,es,tes);
                explorePaths(grid,r,c-1,es,tes);
                grid[r][c] = 1;
            }
            else if(grid[r][c] == 0)
            {
                grid[r][c] = -1;
                explorePaths(grid,r+1,c,es+1,tes);
                explorePaths(grid,r-1,c,es+1,tes);
                explorePaths(grid,r,c+1,es+1,tes);
                explorePaths(grid,r,c-1,es+1,tes);
                grid[r][c] = 0;
            }
            else if(grid[r][c] == -1)
            {
                return ;
            }
        }
    }
    
    public int uniquePathsIII(int[][] grid) 
    {
        int tes = 0;
        int si = -1,sj = -1;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 0)
                {
                    tes += 1;
                }
                else if(grid[i][j] == 1)
                {
                    si = i;
                    sj = j;
                }
            }
        }
        
        explorePaths(grid,si,sj,0,tes);
        
        return ans;
    }
}

// TIME COMPLEXITY : O(V*E) IS THE TIME COMPLEXITY FOR FINDING ALL THE PATHS FROM STARTING TO ENDING POINT, SINCE V IS R*C AND E IS 4. HENCE, THE
// TIME COMPLEXITY IS O(R*C). 
// SPACE COMPLEXITY : O(1)
