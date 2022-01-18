// PROBLEM DESCRIPTION : https://leetcode.com/problems/rotate-image/

// MY APPROACH IS TO FIRST FIND THE TRANSPOSE OF THE MATRIX AND THEN REVERSE EACH ROW TO OBTAIN THE ROTATED MATRIX.

class Solution 
{
    public void rotate(int[][] matrix) 
    {
        int n = matrix.length;
        
        // TRANSPOSING THE GIVEN MATRIX
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // REVERSING EACH ROW IN THE MATRIX
        for(int i=0;i<n;i++)
        {
            int l = 0,r = (n-1);
            
            while(l < r)
            {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l += 1;
                r -= 1;
            }
        }
    }
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)
