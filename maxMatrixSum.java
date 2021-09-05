// THE PROBLEM STATEMENT IS TO MAXIMIZE THE MATRIX SUM OF THE GIVEN MATRIX. WE ARE ALSO ALLOWED TO CHOOSE ANY TWO ADJACENT CELLS IN THE GIVEN MATRIX AND 
// MULTIPLY IT BY -1.

// MY APPROACH IS TO JUST TRAVERSE THE 2-D ARRAY AND NOTE DOWN THE NUMBER OF NEGATIVE NUMBERS PRESENT IN THE 2-D ARRAY, THEN FIND MAXIMUM NEGATIVE NUMBER AND MINMUM POSITIVE 
// NUMBER, THEN MAKE SURE TO ALSO CHECK WHETHER THE MATRIX CONTAINS ZERO IN IT AND ALSO FIND THE SUM OF ALL THE INTEGERS ABSOLUTE VALUE.
// NOW, IF THE NO OF NEGATIVE NUMBERS IS EVEN OR IF THE MATRIX HAS A ZERO THEN RETURN THE SUM, ELSE WE RETURN DIFFERENCE BETWEEN SUM AND DOUBLE THE VALUE OF 
// MINIMUM OF (MAXIMUM NEGATIVE NUMBER , MINIMUM POSITIVE NUMBER).
// THIS PROBLEM WORKS ON THE FACT THAT ANY TWO NEGATIVE PAIR OF ELEMENTS IN THE MATRIX CAN BE MADE POSITIVE.

class Solution 
{
    public long maxMatrixSum(int[][] matrix) 
    {
        long maxNegativeNumber = -Long.MAX_VALUE,noOfNegative = 0,sum = 0,minPositiveNumber = Long.MAX_VALUE;
        Boolean zeroFlag = false;
        
        // TRAVERSING THE GIVEN 2-D MATRIX.
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j] < 0)
                {
                    noOfNegative += 1;
                    
                    if(matrix[i][j] > maxNegativeNumber)
                    {
                        maxNegativeNumber = matrix[i][j];
                    }
                    
                    sum += (-matrix[i][j]);
                }
                else if(matrix[i][j] > 0)
                {
                    sum += matrix[i][j];
                    
                    if(matrix[i][j] < minPositiveNumber)
                    {
                        minPositiveNumber = matrix[i][j];
                    }
                }
                else
                {
                    zeroFlag = true;
                }
            }
        }
        
        if(noOfNegative%2 == 0 || zeroFlag)
        {
            return sum;
        }
        
        return sum-(Math.min(-maxNegativeNumber,minPositiveNumber)*2);
    }
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)
