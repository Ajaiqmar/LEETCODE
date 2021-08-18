// THE PROBLEM STATEMENT IS TO RETURN RESTORED MATRIX WHEN ROWSUM ARRAY AND COLSUM ARRAY IS GIVEN.

// MY APPROACH IS TO TRAVERSE THE ARRAY AND AT EACH CELL REFER TO ITS ROW SUM AND COL SUM VALUE ,THEN STORE THE MINIMUM VALUE OF BOTH INTO THE CELL.
// AFTER STORING IT, REDUCE THE VALUE FROM THE ROW SUM AND COL SUM VALUES.

int** restoreMatrix(int* rowSum, int rowSumSize, int* colSum, int colSumSize, int* returnSize, int** returnColumnSizes)
{
    int** matrix = (int**)malloc(sizeof(int*)*rowSumSize);
    *returnColumnSizes = (int*)malloc(sizeof(int)*rowSumSize);
    *returnSize = rowSumSize;
    
    for(int i=0;i<rowSumSize;i++)
    {
        matrix[i] = (int*)malloc(sizeof(int)*colSumSize);
        (*returnColumnSizes)[i] = colSumSize;
    }
    
    // TRAVERSING THE RESTORED ARRAY AND INITIALSING EACH CELL IN THE MATRIX.
    for(int i=0;i<rowSumSize;i++)
    {
        for(int j=0;j<colSumSize;j++)
        {
            int val = ((rowSum[i] < colSum[j])?rowSum[i]:colSum[j]);
            
            matrix[i][j] = val;
            
            rowSum[i] -= val;
            colSum[j] -= val;
        }
    }
    
    return matrix;
}

// TIME COMPLEXITY : O(N*M)
// SPACE COMPLEXITY : O(N*M)
