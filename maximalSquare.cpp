// THE PROBLEM STATEMENT IS TO PRINT THE AREA OF THE LARGEST SQUARE CONTAINING ONLY 1'S IN THE GIVEN BINARY MATRIX M x N.

// MY APPROACH IS TO FIND THE ROW PREFIX SUM, COLUMN PREFIX SUM AND DIAGONAL PREFIX SUM FOR THE GIVEN BINARY MATRIX, THEN FIND THE MINMUM OF
// ALL THE THREE TO PINPOINT SIDE OF THE SQUARE. FINALLY RETURN THE SQUARE OF THE SIDE. HERE PREFIX SUM REPRESENTS THE NUMBER OF CONTINOUS 1'S IN A ROW OR A
// COLUMN BUT IN TERMS OF DIAGONAL WE ADD THE MINIMUM OF ROW PREFIX SUM, COLUMN PREFIX SUM AND DIAGONAL PREFIX SUM OF THE PREVIOUS DIAGONAL.

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) 
    {
        int m = matrix.size(),n = matrix[0].size();
        int r[m][n],c[m][n],d[m][n];
        int ans = 0;
        
        // TRAVERSING THE GIVEN BINARY MATRIX.
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                // CALCULATING ROW PREFIX SUM. 
                if(j == 0)
                {
                    if(matrix[i][j] == '1')
                    {
                        r[i][j] = 1;
                    }
                    else
                    {
                        r[i][j] = 0;
                    }
                }
                else
                {
                    if(matrix[i][j] == '1')
                    {
                        r[i][j] = 1;
                        r[i][j] += r[i][j-1];
                    }
                    else
                    {
                        r[i][j] = 0;
                    }
                }
                
                // CALCULATING COLUMN PREFIX SUM.
                if(i == 0)
                {
                    if(matrix[i][j] == '1')
                    {
                        c[i][j] = 1;
                    }
                    else
                    {
                        c[i][j] = 0;
                    }
                }
                else
                {
                    if(matrix[i][j] == '1')
                    {
                        c[i][j] = 1;
                        c[i][j] += c[i-1][j];
                    }
                    else
                    {
                        c[i][j] = 0;
                    }
                }
                
                // CALCULATING DIAGONAL PREFIX SUM.
                if(i == 0 || j == 0)
                {
                    if(matrix[i][j] == '1')
                    {
                        d[i][j] = 1;
                    }
                    else
                    {
                        d[i][j] = 0;
                    }
                }
                else
                {
                    if(matrix[i][j] == '1')
                    {
                        d[i][j] = 1;
                        d[i][j] += min(r[i-1][j-1],min(c[i-1][j-1],d[i-1][j-1]));
                    }
                    else
                    {
                        d[i][j] = 0;
                    }
                }
                
                ans = max(ans,min(c[i][j],min(d[i][j],r[i][j]))); 
            }
        }
        
        return ans*ans;
    }
};

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N*N)
