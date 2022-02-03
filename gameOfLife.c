// PROBLEM DESCRIPTION : https://leetcode.com/problems/game-of-life/

// MY APPROACH IS TO TRAVERSE THE ARRAY AND CHECK FOR THE GIVEN CONDITIONS BY COUNTING THE NUMBER OF ZEROS AND ONES IN THE NEIGHBOURING CELLS. SINCE WE HAVE
// BEEN ASKED TO DEVISE THE SOLUTION WITHOUT USING ADDITIONAL SPACE. WHAT I THOUGHT IS WHY DON'T WE ASSIGN VALUES ON OUR OWN TO REPRESENT TWO
// SPECIFIC SCENARIOS WHICH ARE RESURRECTION (DEAD TO ALIVE) AND DEATH (ALIVE TO DEAD), SO I ASSIGNED 2 AND 3 TO BE THE RESPECTIVE SCENARIOS. THIS WILL
// HELP US TO SOLVE THE PROBLEM WITHOUT USING ADDITIONAL SPACE.

void gameOfLife(int** board, int boardSize, int* boardColSize)
{
    int r = boardSize,c = *boardColSize;
    
    // TRAVERSING THE GIVEN BOARD.
    for(int i=0;i<r;i++)
    {
        for(int j=0;j<c;j++)
        {
            int countOfOnes = 0,countOfZeros = 0;
            
            if(i > 0 && (board[i-1][j] == 1 || board[i-1][j] == 3))
            {
                countOfOnes += 1;
            }
            else
            {
                countOfZeros += 1;
            }
            
            if(j > 0 && (board[i][j-1] == 1 || board[i][j-1] == 3))
            {
                countOfOnes += 1;
            }
            else
            {
                countOfZeros += 1;
            }
            
            if(i < (r-1) && (board[i+1][j] == 1 || board[i+1][j] == 3))
            {
                countOfOnes += 1;
            }
            else
            {
                countOfZeros += 1;
            }
            
            if(j < (c-1) && (board[i][j+1] == 1 || board[i][j+1] == 3))
            {
                countOfOnes += 1;
            }
            else
            {
                countOfZeros += 1;
            }
            
            if(i > 0 && j > 0 && (board[i-1][j-1] == 1 || board[i-1][j-1] == 3))
            {
                countOfOnes += 1;
            }
            else
            {
                countOfZeros += 1;
            }
            
            if(i < (r-1) && j < (c-1) && (board[i+1][j+1] == 1 || board[i+1][j+1] == 3))
            {
                countOfOnes += 1;
            }
            else
            {
                countOfZeros += 1;
            }
            
            if(i > 0 && j < (c-1) && (board[i-1][j+1] == 1 || board[i-1][j+1] == 3))
            {
                countOfOnes += 1;
            }
            else
            {
                countOfZeros += 1;
            }
            
            if(i < (r-1) && j > 0 && (board[i+1][j-1] == 1 || board[i+1][j-1] == 3))
            {
                countOfOnes += 1;
            }
            else
            {
                countOfZeros += 1;
            }
            
            if(board[i][j] == 0 && countOfOnes == 3)
            {
                board[i][j] = 2;
            }
            
            if(board[i][j] == 1)
            {
                if(countOfOnes < 2)
                {
                    board[i][j] = 3;
                }
                else if(countOfOnes > 3)
                {
                    board[i][j] = 3;
                }
            }
        }
    }
    
    // REPLACING THE SCENARIO VALUES BACK TO 1'S AND 0'S.
    for(int i=0;i<r;i++)
    {
        for(int j=0;j<c;j++)
        {
            if(board[i][j] == 2)
            {
                board[i][j] = 1;
            }
            else if(board[i][j] == 3)
            {
                board[i][j] = 0;
            }
        }
    }
}

// TIME COMPLEXITY : O(M*N)
// SPACE COMPLEXITY : O(1)
