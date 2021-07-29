// THE PROBLEM STATEMENT IS TO CHECK IF THE GIVEN MATRIX IS EQUAL TO THE TARGET, BY ROTATING THE MATRIX IN 90-DEGREE IMCREMENTS.
// MY APPROACH IS TO ROTATE IT 4 TIMES AND CHECK IF ANY ONE OF THE MATRIX IS EQUAL TO THE TARGET MATRIX.

// ROTATE FUNCTION - ROTATES THE GIVEN MATRIX BY 90 - DEGREE
// ISEQUALS FUNCTION - CHECKS IF THE GIVEN MATRIX IS EQUAL TO THE TARGET MATRIX.

void rotate(int** mat,int n)
{
    int temp[n][n];
    for(int i=0;i<n;i++)
    {
        for(int j=0,k=n-1;j<n;j++,k--)
        {
            temp[i][j] = mat[k][i];
        }
    }
    
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            mat[i][j] = temp[i][j];
        }
    }
}

bool isEquals(int** mat,int** target,int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(mat[i][j] != target[i][j])
            {
                return false;
            }
        }
    }
    return true;
}

bool findRotation(int** mat, int matSize, int* matColSize, int** target, int targetSize, int* targetColSize)
{
    for(int i=0;i<4;i++)
    {
        rotate(mat,matSize);
        if(isEquals(mat,target,matSize))
        {
            return true;
        }
    }
    return false;
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N*N)
