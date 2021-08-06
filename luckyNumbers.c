

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
// THE PROBLEM STATEMENT IS TO FIND ALL THE LUCKY NUMBERS PRESENT IN THE MATRIX.
// A LUCKY NUMBER IS DEFINED AS A NUMBER WHICH IS THE MINIMUM VALUE IN A ROW AND MAXIMUM VALUE IN THE COULMN OF A GIVEN MATRIX.

// MY APPROACH IS TO APPLY THE BRUTE FORCE APPROACH FINDING THE MINIMUM VALUE ROW WISE AND THEN TRAVERSING THE MINIMUM VALUE COLUMN TO CHECK
// IF IT IS THE MAXIMUM VALUE COLUMN WISE.

int* luckyNumbers (int** matrix, int matrixSize, int* matrixColSize, int* returnSize)
{
    int* ans = (int*)malloc(sizeof(int)*matrixSize);
    *returnSize = 0;
    
    for(int i=0;i<matrixSize;i++)
    {
        int colIndex = -1,minValue = INT_MAX,flag = 0;
        
        // TRAVERSING THE MATRIX ROW-WISE TO GET THE MINIMUM VALUE.
        for(int j=0;j<*matrixColSize;j++)
        {
            if(matrix[i][j] < minValue)
            {
                minValue = matrix[i][j];
                colIndex = j;
            }
        }
        
        // TRAVERSING THE MATRIX COLUMN-WISE TO CHECK IF IT IS MAXIMUM.
        for(int j=0;j<matrixSize;j++)
        {
            if(matrix[j][colIndex] > minValue)
            {
                flag = 1;
                break;
            }
        }
        
        if(flag == 0)
        {
            ans[(*returnSize)++] = minValue;
        }
    }
    
    return ans;
}

// TIME COMPLEXITY : O(M*MAX(M,N)) FOR EACH ROW WE WILL BE TRAVERSING ROW-WISE AS WELL AS COLUMN-WISE.
// SPACE COMPLEXITY : O(M)
