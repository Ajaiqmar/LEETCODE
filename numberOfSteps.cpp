// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF STEPS TO REDUCE THE GIVEN INTEGER TO ZERO.

// THE CONDITIONS ARE, IF IT IS EVEN DIVIDE IT BY 2 ELSE REDUCE IT BY 1.

// MY APPROACH IS TO SIMPLY APPLY THE BRUTE FORCE APPROACH.

class Solution 
{
public:
    int numberOfSteps(int num) 
    {
        int countOfSteps = 0;
        
        while(num > 0)
        {
            if(num%2 == 0)
            {
                num = num/2;
            }
            else
            {
                num = num-1;
            }
            countOfSteps++;
        }
        
        return countOfSteps;
    }
};

// TIME COMPLEXITY : O(LOG N)
// SPACE COMPLEXITY : O(1)
