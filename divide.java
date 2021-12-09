// THE PROBLEM STATEMENT IS TO RETURN THE FLOOR VALUE OF THE GIVEN QUOTIENT WHEN THE DIVIDEND AND THE DIVISOR IS GIVEN WITHOUT USING
// DIVISION OR MODULO OR MULTIPLICATION OPERATOR. 

// MY APPROACH IS TO REDUCE THE DIVIDEND BY DIVISOR USING SUBTRACTION OPERATOR UNTIL THE DIVIDEND IS LESS THAN THE DIVISOR, COUNT THE NUMBER
// OF TIMES THE OERATION IS CARRIED OUT AND THEN RETURN THE VALUE.

class Solution 
{
    public int divide(int dividend, int divisor) 
    {
        int ans = 0;
        int x = dividend,y = divisor;
        
        // IF DIVIDEND IS EQUAL TO DIVISOR THEN RETURN 1.
        if(x == y)
        {
            ans = 1;
        }
        else
        {
            if(x < 0 && y < 0)
            {
                if(x == Integer.MIN_VALUE && y == -1)
                {
                    return Integer.MAX_VALUE;
                }
                
                while(x <= y)
                {
                    x -= y;
                    ans += 1;
                }
            }
            else if(x > 0 && y > 0)
            {
                while(x >= y)
                {
                    x -= y;
                    ans += 1;
                }
            }
            else
            {
                if(x == Integer.MIN_VALUE && y == 1)
                {
                    return Integer.MIN_VALUE;
                }
                else
                {
                    if(y > 0)
                    {
                        y = -y;
                    }
                    
                    if(x > 0)
                    {
                        x = -x;
                    }
                    
                    while(x <= y)
                    {
                        x -= y;
                        ans += 1;
                    }
                }
            }
        }
        
        // CHECK WHETHER THE QUOTIENT IS NEGATIVE OR POSITIVE.
        if((dividend < 0 && divisor < 0) || (divisor > 0 && dividend > 0))
        {
            return ans;
        }
        else
        {
            return -ans;
        }
    }
}

// TIME COMPLEXITY : O(Q) WHERE Q IS THE QUOTIENT.
// SPACE COMPLEXITY : O(1)
