class Solution 
{
    public static int checkForPawns(char[][] board,int x,int y)
    {
        int ans = 0,i = x,j = y;
        while(i>=0)
        {
            if(board[i][j] == 'p')
            {
                ans++;
                break;
            }
            else if(board[i][j] == 'B')
            {
                break;
            }
            i--;
        }
        i = x;
        j = y;
        while(j>=0)
        {
            if(board[i][j] == 'p')
            {
                ans++;
                break;
            }
            else if(board[i][j] == 'B')
            {
                break;
            }
            j--;
        }
        i = x;
        j = y;
        while(j<8)
        {
            if(board[i][j] == 'p')
            {
                ans++;
                break;
            }
            else if(board[i][j] == 'B')
            {
                break;
            }
            j++;
        }
        i = x;
        j = y;
        while(i<8)
        {
            if(board[i][j] == 'p')
            {
                ans++;
                break;
            }
            else if(board[i][j] == 'B')
            {
                break;
            }
            i++;
        }
        
        return ans;
    }
    
    public int numRookCaptures(char[][] board) 
    {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(board[i][j] == 'R')
                {
                    return checkForPawns(board,i,j);
                }
            }
        }
        
        return 0;
    }
}
