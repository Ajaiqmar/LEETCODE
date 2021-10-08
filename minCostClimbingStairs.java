// THE PROBLEM STATEMENT IS TO RETURN MINIMUM COST TO REACH THE TOP OF THE FLOOR. YOU ARE GIVEN AN INTEGER ARRAY COST WHERE COST[i] IS THE COST OF i-TH STEP ON A STAIRCASE. 
// ONCE YOU PAY THE COST, YOU CAN EITHER CLIMB ONE OR TWO STEPS. YOU CAN EITHER START FROM THE STEP WITH INDEX 0, OR THE STEP WITH INDEX 1.

// MY APPROACH IS TO USE DYNAMIC PROGRAMMING, WE CAN PREDICT THE MINIMUM COST TO CLIMB BY LOOKING USING THE SUCCESSOR STEP VALUES USING RECURSION, BUT IT MAY CAUSE
// TIME LIMIT EXCEEDED ERROR SINCE THE TIME COMPLEXITY WOULD BE 2^N. SO, WE USE DYNAMIC PROGRAMMING. IN DP, WE LOOK AT THE PREDECESSOR VALUES, SINCE WE CAN START EITHER 
// FROM 0 0R 1, WE WILL BE STARTING FROM THE INDEX 2, NOW WE WILL ADD THE CURRENT INDEX ELEMENT TO THE SUM OF THE PREVIOUS TWO ELEMENTS. FINALLY, WE RETURN THE
// MINIMUM OF THE LAST TWO INDICES VALUE.

class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int n = cost.length;
        // TRAVERSING THE GIVEN ARRAY.
        for(int i=2;i<n;i++)
        {
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }
        
        return Math.min(cost[n-1],cost[n-2]);
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
