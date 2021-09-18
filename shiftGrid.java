// THE PROBLEM STATEMENT IS TO ROTATE THE MATRIX IN AN ANTI-CLOCKWISE MANNER K TIMES.

// MY APPROACH IS TO FIRST CONVERT THE 2D - MATRIX INTO A 1D - MATRIX THEN MAKE SURE THE VALUE OF K IS LESS THAN THE LENGTH OF
// THE ID - MATRIX. INORDER TO AVOID REPETITION OF THE OPERATION. THEN REVERSE THE ELEMENTS IN THE ARRAY FROM 0 TO L-K AND L-K TO L.
// THEN REVERSE THE WHOLE ARRAY TO GET THE ARRAY AFTER ANTI-CLOCK WISE ROTATION. THEN CONVERT THE 1D ARRAY TO A 2D ARRAY AGAIN. 

class Solution 
{
    // FUNCTION TO REVERSE THE ARRAY FROM INDEX LEFT TO RIGHT.
    public static void swap(int[] arr,int left,int right)
    {
        while(left < right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left += 1;
            right -= 1;
        }
    }
    
    public List<List<Integer>> shiftGrid(int[][] grid, int k) 
    {
        int r = grid.length,c = grid[0].length;
        int[] arr = new int[r*c];
        int l = 0;
        
        // COVERTING THE 2D ARRAY TO 1D ARRAY.
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                arr[l] = grid[i][j];
                l += 1;
            }
        }
        
        k = k%l;
        
        swap(arr,0,(l-(k+1)));
        swap(arr,(l-k),(l-1));
        swap(arr,0,l-1);
        
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        int ind = 0;
        
        // CONVERTING 1D ARRAY TO 2D ARRAY.
        for(int i=0;i<r;i++)
        {
            List<Integer> a = new ArrayList<Integer>();
            for(int j=0;j<c;j++)
            {
                a.add(arr[ind]);
                ind += 1;
            }
            matrix.add(a);
        }
        
        return matrix;
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF ELEMENTS IN THE 2D ARRAY.
// SPACE COMPLEXITY : O(N)
