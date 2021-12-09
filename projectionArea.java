// THE PROBLEM STATEMENT IS TO RETURN THE SUM OF THE AREA OF THE PROJECTIONS CREATED BY THE GIVEN THREE DIMENSIONAL OBJECT.
// THE THREE DIMENSIONAL OBJECT IS REPRESENTED IN THE FORM OF 2D ARRAY WHERE EACH CELL CONTAINS THE NUMBER OF SQUARE CUBES IN THAT PARTICULAR X,Y PLANE.
// EACH SQUARE CUBE'S DIMENSION IS 1 X 1 X 1.

// MY APPROACH IS TO FIRST INITIALISE THE ANSWER VARIABLE WITH THE SQUARE OF N WHERE N IS THE DIMENSIONS OF THE GIVEN 2D - ARRAY. THEN, TRAVERSE THE GIVEN 2D - ARRAY
// TO FIND THE ROW-WISE MAXIMUM AND THE COLUMN-WISE MAXIMUM THEN ADD THAT TO THE ARRAY. ALSO KEEP IN MIND TO CHECK IF ANY CELL HAS THE VALUE AS ZERO, IF THERE IS
// THEN DECREMENT THE ANSWER VALUE BY ONE FOR EACH ZERO PRESENT IN THE GIVEN 2D ARRAY. ATLAST RETURN THE VALUE OF THE ANSWER.

class Solution 
{
    public int projectionArea(int[][] grid) 
    {
        int n = grid.length;
        int ans = n*n;
        
        // TRAVERSING THE GIVEN 2D ARRAY.
        for(int i=0;i<n;i++)
        {
            int rma = -1,cma = -1;
            
            for(int j=0;j<n;j++)
            {
                rma = Math.max(rma,grid[i][j]);
                cma = Math.max(cma,grid[j][i]);
                
                if(grid[i][j] == 0)
                {
                    ans -= 1;
                }
            }
            
            ans += (rma+cma);
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)
