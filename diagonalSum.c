// THE PROBLEM STATEMENT IS TO FIND THE SUM OF ALL THE DIAGONAL ELEMENTS IN A MATRIX WITHOUT VALUES OVERLAPPING.

// MY APPROACH IS TO TRAVERSE ONLY THE DIAGONAL ELEMENTS USING A WHILE LOOP AND ADD THE VALUE TO THE ANSWER, AS WE ARE TRAVERSING
// THE DIAGONAL ELEMENTS CHANGE THE VALUES TO ZERO, INORDER TO MAKE SURE THAT THE ELEMENTS DO NOT OVERLAP. 

int diagonalSum(int** mat, int matSize, int* matColSize)
{
    int i = 0,j = 0,ans = 0;
    
    // TRAVERSING THE LEFT DIAGONAL.
    while(i<matSize && j<matSize)
    {
        ans += mat[i][j];
        mat[i][j] = 0;
        i++;
        j++;
    }
    
    i = 0;
    j = matSize-1;
    
    // TRAVERSING THE RIGHT DIAGONAL.
    while(i<matSize && j>=0)
    {
        ans += mat[i][j];
        mat[i][j] = 0;
        i++;
        j--;
    }
    
    return ans;
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF DIAGONAL ELEMENTS.
// SPACE COMPLEXITY : O(1)
