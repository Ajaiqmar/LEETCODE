// PROBLEM DESCRIPTION : https://leetcode.com/problems/unique-paths/

// MY APPROACH IS TO DO A DEPTH FIRST SEARCH WITH MEMOIZATION TO FIND OUT THE NUMBER OF UNIQUE PATHS. SO, HOW IT WILL WORK IS FIRST WE WILL DO A DFS TO THE BOTTOM-RIGHT
// CORNER, NOW ONCE WE REACH THE CORNER, WHILE BACKTRACKING WE WILL STORE THE PATHS VALUE IN A TWO DIMENSIONAL ARRAY. THE REASON BEING WHY IS WE DON'T 
// HAVE TO GO THROUGH THE TROUBLE OF DOING A DFS AGAIN TO THE SAME PATH. THIS WILL REDUCE THE TIME COMPLEXITY FROM EXPONENTIAL TO LINEAR, SINCE
// WE VISIT THE PATH VALUES ONLY ONCE.

// FUNCTION TO CARRY OUT THE DFS WITH MEMOIZATION OPERATION.
int dfsWithMemoization(int x,int y,int m,int n,int** dp,int* ans)
{
    if(x >= 0 && x < m && y >= 0 && y < n)
    {
        if(x == m-1 && y == n-1)
        {
            *ans += 1;
            return 1;
        }
        
        if(dp[x][y] == -1)
        {
            return 0;
        }
        else if(dp[x][y] > 0)
        {
            *ans += dp[x][y];
        }
        else
        {
            // STORING THE PATH VALUES INTO THE DP ARRAY.
            dp[x][y] = dfsWithMemoization(x+1,y,m,n,dp,ans)+dfsWithMemoization(x,y+1,m,n,dp,ans);
        
            if(dp[x][y] == 0)
            {
                dp[x][y] = -1;
                
                return 0;
            }
        }
        
        return dp[x][y];
    }
    
    return 0;
}

int uniquePaths(int m, int n)
{
    int** dp = (int**)malloc(sizeof(int*)*m);
    int ans = 0;
    for(int i=0;i<m;i++)
    {
        dp[i] = (int*)malloc(sizeof(int)*n);
    }
    
    dfsWithMemoization(0,0,m,n,dp,&ans);
    
    return ans;
}

// TIME COMPLEXITY : O(M*N)
// SPACE COMPLEXITY : O(M*N)
