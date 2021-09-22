// THE PROBLEM STATEMENT IS TO FIND THE SUM OF HOW MUCH THE HEIGHT OF EACH BLOCK CAN BE INCREASED WITHOUT AFFECTING THE SKYLINE. THE GIVEN GRID 2D-ARRAY REPRESENTS
// THE LAYOUT OF THE CITY, WHERE EACH BLOCK REPRESENTS A BUILDING AND THE VALUE REPRESENTS THE HEIGHT OF THAT BUILDING. THE SKYLINE IS HOW THESE BUILDING
// WOULD LOOK LIKE FROM A POSITION FAR AWAY TOWARDS NORTH, SOUTH, EAST OR WEST. NOW WE HAVE TO MAINTAIN THE SKYLINE AS WELL AS TRY TO INCREASE THE
// HEIGHT OF THE BUILDINGS. FINALLY RETURN THE SUM OF EXTRA HEIGHT ADDED TO EACH BUILDING.

// MY APPROACH IS TO FIND OUT THE MAXIMUM VALUE IN EACH ROW AND MAXIMUM VALUE IN EACH COLUMN, THEN STORE THEM IN THE FORM OF ARRAY.
// NEXT STEP WOULD BE TO TRAVERSE THE GRID, WHILE TRAVERSING AT EACH BLOCK FIND THE MINIMUM OF MAXIMUM HEIGHT OF BUILDING IN TERMS OF ROWS AND COLUMNS,
// NOW CHECK IF THE CURRENT BLOCK'S HEIGHT IS LESS THAN THE MINIMUM VALUE, IF IT IS FIND THE DIFFERENCE AND ADD THAT VALUE TO THE ANSWER. FINALLY
// RETURN THE ANSWER.

class Solution 
{
    public int maxIncreaseKeepingSkyline(int[][] grid) 
    {
        int r = grid.length,c = grid[0].length,ans = 0;
        int[] rowMax = new int[r];
        int[] colMax = new int[c];
        
        // FINDING THE MAXIMUM HEIGHT IN TERMS OF ROWS.
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j] > rowMax[i])
                {
                    rowMax[i] = grid[i][j];
                }
            }
        }
        
        // FINDING THE MAXIMUM HEIGHT IN TERMS OF COLUMNS.
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                if(grid[j][i] > colMax[i])
                {
                    colMax[i] = grid[j][i];
                }
            }
        }
        
        // FINDING OUT THE EXTRA HEIGHT THAT CAN BE ADDED TO EACH BLOCK.
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j] < Math.min(rowMax[i],colMax[j]))
                {
                    ans += (Math.min(rowMax[i],colMax[j])-grid[i][j]);
                }
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(R*C)
// SPACE COMPLEXITY : O(R+C)

