// THE PROBLEM STATEMENT IS TO CHECK WHETHER THE GIVEN 9*9 SUDOKU BOARD IS VALID.
// A VALID SUDOKU BOARD WILL CONTAIN DIGITS FROM '0' TO '9' AND THAT EVERY ROW, COLUMN AND 3*3 GRID CONTAINS NON-REPETITIVE DIGITS FROM '0' TO '9'.

// MY APPROACH IS TO USE HASHTABLE TO VERIFY THAT EVERY ROW, COLUMN, AND 3*3 GRID CONTAINS NON-REPETITIVE DIGITS FROM '0' TO '9'.
// WE CAN USE THE DIGITS AS THE KEY AND I-TH NUMBER OF ROW , COLUMN OR GRID AS VALUE. 

class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        int[] rows = new int[10];
        int[] cols = new int[10];
        int[] grid = new int[10];
        
        // TRAVERSING EACH ROW AND COLUMN.
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j] >= '0' && board[i][j] <= '9')
                {
                    int ind = board[i][j]-'0';

                    if(rows[ind] == i+1)
                    {
                        return false;
                    }
                    
                    rows[ind] = i+1;
                }
                
                if(board[j][i] >= '0' && board[j][i] <= '9')
                {
                    int ind = board[j][i]-'0';
                    
                    if(cols[ind] == i+1)
                    {
                        return false;
                    }
                    
                    cols[ind] = i+1;
                }
            }
        }
        
        int val = 1;
        
        // TRAVERSING EACH GRID.
        for(int i=0;i<9;i+=3)
        {
            for(int j=0;j<9;j+=3)
            {
                
                for(int row=i;row<i+3;row++)
                {
                    for(int col=j;col<j+3;col++)
                    {
                        if(board[row][col] >= '0' && board[row][col] <= '9')
                        {
                            int ind = board[row][col]-'0';
    
                            if(grid[ind] == val)
                            {
                                return false;
                            }
                        
                            grid[ind] = val;
                        }
                    }
                }
                
                val += 1;
            }
        }
        
        return true;
    }
}

// TIME COMPLEXITY : O(N*N) WHERE N IS THE DIMENSION OF THE SUDOKU BOARD.
// SPACE COMPLEXITY : O(N)
