// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF ODD VALUED CELLS. GIVEN M AND N WHERE M AND N ARE DIMENSIONS OF AN 2-D ARRAY IN WHICH
// EACH CELLS ARE INITIALISED TO 0, THERE IS ALSO AN 2-D INDICES ARRAY WHICH CONTAINS ROW AND COLUMN VALUE AT EACH INDEX. OUR JOB IS TO INCREMENT THE CELLS OF THE FORMED
// 2-D ARRAY PRESENT IN EACH ROW AND COLUMN INDEX IN EACH INDEX OF THE INDICES ARRAY. THEN RETURN THE ODD VALUED CELLS.

// FOLLOW UP QUESTION WAS TO DO THIS IN O(N+M+INDICES.LENGTH) TIME AND O(M+N) SPACE.

// MY APPROACH IS TO CREATE TWO ARRAYS OF LENGTH M AND N, ALSO INITIALISE TO ZERO. THEN TRAVERSE THE INDICES ARRAY, TO COUNT THE NUMBER OF INCREMENTS IN
// EACH ROW AND COLUMN. THEN TRAVERSE THOSE ARRAY TO FIND THE NUMBER OF ODD INCREMENTS IN EACH ROW AND COLUMN. NOW FINDING OUT THE NUMBER ODD VALUED CELLS
// IS PRETTY EASY. WE HAVE TO MULTIPLY THE NO. OF ODD INCREMENTS ROW WISE WITH THE NO. OF COLUMNS THEN ADD THIS WITH
// NO. OF ODD INCREMENTS COLUMN WISE WITH THE NO. OF ROWS THEN SUBTRACT THE OVERLAPPING AREAS FROM THIS.

class Solution 
{
    public int oddCells(int m, int n, int[][] indices) 
    {
        int[] row = new int[m];
        int[] col = new int[n];
        int oddValuedCell = 0;
        
        // COUNTING THE NUMBER OF INCREMENTS ROW WISE AND COLUMN WISE.
        for(int i=0;i<indices.length;i++)
        {
            row[indices[i][0]] += 1;
            col[indices[i][1]] += 1;
        }
        
        int o1=0,o2=0;
        
        // COUNTING THE NUMBER OF ODD INCREMENTS ROW WISE.
        for(int i=0;i<m;i++)
        {
            if(row[i] != 0)
            {
                if(row[i]%2 != 0)
                {
                    o1 += 1;
                }
            }
        }
        
        // COUNTING THE NUMBER OF ODD INCREMENTS COLUMN WISE.
        for(int i=0;i<n;i++)
        {
            if(col[i] != 0)
            {
                if(col[i]%2 != 0)
                {
                    o2 += 1;
                }
            }
        }
        
        oddValuedCell = (n*o1)+(m*o2)-(2*o1*o2);
            
        return oddValuedCell;
    }
}

// TIME COMPLEXITY : O(N+M+INDICES.LENGTH)
// SPACE COMPLEXITY : O(N+M)
