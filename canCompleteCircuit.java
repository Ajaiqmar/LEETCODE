// PROBLEM DESCRIPTION : https://leetcode.com/problems/gas-station/

// MY APPROACH IS TO CHECK WHETHER IT IS POSSIBLE TO DO A ROUND TRIP FIRST, THIS CAN BE CHECK BY FINDING THE SUM OF DIFFERENCE BETWEEN THE GAS VALUE AND THE COST VALUE 
// AT EACH INDEX. WHILE DOING THAT USE KADANE ALGORITHM TO PINPOINT THE STARTING INDEX THAT IS FEASIBLE TO DO THE ROUND TRIP.

class Solution 
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int travelCost = 0,val = 0,ans = -1;
        
        // TRAVERSING THE GIVEN ARRAY TON CHECK IF IT IS POSSIBLE TO DO A ROUND TRIP. IF IT IS POSSIBLE THEN FINDING OUT THE STARTING INDEX.
        for(int i=0;i<gas.length;i++)
        {
            travelCost += (gas[i]-cost[i]);
            
            if(val <= 0)
            {
                ans = i;
                val = (gas[i]-cost[i]);
            }
            else
            {
                val += (gas[i]-cost[i]);
            }
        }
        
        if(travelCost >= 0)
        {
            return ans;
        }
        
        return -1;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
