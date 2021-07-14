int maximumWealth(int** accounts, int accountsSize, int* accountsColSize)
{
    int maxWealth = INT_MIN;
    
    for(int i=0;i<accountsSize;i++)
    {
        int wealth = 0;
        
        for(int j=0;j<*accountsColSize;j++)
        {
            wealth += accounts[i][j];
        }
        
        if(wealth > maxWealth)
        {
            maxWealth = wealth;
        }
    }
    
    return maxWealth;
}
