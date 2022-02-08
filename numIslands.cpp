// PROBLEM DESCRIPTION : https://leetcode.com/problems/number-of-islands/

// MY APPROACH IS TO TRAVERSE THE GIVEN GRID, WHILE TRAVERSING IF WE ENCOUNTER THE CHARACTER '1' THEN WE WILL SINK THE ISLAND THAT THE ONE IS ASSOCIATED WITH, BY THAT I
// MEAN CONVERT ALL THE '1' TO '-' USING DEPTH FIRST SEARCH AND INCREMENT THE ANSWER COUNT. FINALLY, RETURN THE VALUE OF ANS VARIABLE.

class Solution {
public:
    // DEPTH FIRST SEARCH FUNCTION.
    void sinkTheIsland(vector<vector<char>>& grid,int i,int j,int r,int c)
    {
        if(i >= 0 && i < r && j >= 0 && j < c)
        {
            if(grid[i][j] == '1')
            {
                grid[i][j] = '-';
                
                sinkTheIsland(grid,i+1,j,r,c);
                sinkTheIsland(grid,i-1,j,r,c);
                sinkTheIsland(grid,i,j+1,r,c);
                sinkTheIsland(grid,i,j-1,r,c);
            }
        }
    }
   
    int numIslands(vector<vector<char>>& grid)
    {
        int r = grid.size(),c = grid[0].size();
        int ans = 0;
        
        // TRAVERSING THE GRID.
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j] == '1')
                {
                    ans += 1;
                    sinkTheIsland(grid,i,j,r,c);
                }
            }
        }
        
        return ans;
    }
};

// TIME COMPLEXITY : O(M*N)
// SPACE COMPLEXITY : O(M*N)
