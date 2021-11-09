// THE PROBLEM STATEMENT IS TO SORT THE GIVEN MATRIX DIAGONAL WISE IN ASCENDING ORDER. A DIAGONAL CONSTITUTES OF INTEGERS FROM THE TOP LEFT TO THE BOTTOM
// RIGHT CORNER OF THE MATRIX.

// MY APPROACH IS TO TRAVERSE THE MATRIX AND DO AN INSERTION SORT DIAGONALLY USING THE MOVE UP FUNCTION. THE MOVE UP FUNCTION SWAPS
// THE CURRENT VALUE AND THEIR DIAGONAL PREDECESSOR IF THE CURRENT ELEMENT IS LESS THAN THE DIAGONAL PREDECESSOR.

class Solution 
{
    // FUNCTION TO CARRY OUT THE INSRERTION SORT DIAGONALLY.
    public void moveUp(int[][] mat,int i,int j)
    {
        int r = mat.length;
        int c = mat[0].length;
        
        while(i > 0 && i < r && j > 0 && j < c && mat[i][j] < mat[i-1][j-1])
        {
            int temp = mat[i][j];
            mat[i][j] = mat[i-1][j-1];
            mat[i-1][j-1] = temp;
            i -= 1;
            j -= 1;
        }
    }
    public int[][] diagonalSort(int[][] mat) 
    {
        int r = mat.length;
        int c = mat[0].length;
        
        // TRAVERSING THE GIVEN MATRIX.
        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                moveUp(mat,i,j);
            }
        }
        
        return mat;
    }
}

// TIME COMPLEXITY : O(R*C*MAX(R,C))
// SPACE COMPLEXITY : O(1)
