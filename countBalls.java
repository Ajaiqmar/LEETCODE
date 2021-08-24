// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF BALLS IN THE BOX WITH MOST BALLS. IN A FACTORY THERE ARE INFINITE NUMBER OF BOXES NUMBERED FROM
// 1 TO INFINITE, WE HAVE BEEN GIVEN A LOW AND A HIGH LIMIT INTEGER, FOR EACH LIMIT WE HAVE TO FIND THE SUM OF THAT INTEGER THEN PLACE THE BALL IN THAT NUMBERED
// BOX. THEN CHECK IF THE NUMBER OF BALLS INSIDE THE BOX IS THE HIGHEST NUMBER OF BALLS AMONG ALL THE BOXES.

// MY APPROACH IS TO TRAVERSE THE LIMIT AND FIND THE SUM OF ITS DIGITS, THEN USE A HASHTABLE TO COUNT THE TOTAL NUMBER OF BALLS IN EACH BOX BY INCREMENTING
// THE CORRESPONDING INDEX. KEEP A SEPERATE VARIABLE TO KEEP IN CHECK OF THE HIGHEST NUMBER OF BALLS IN EACH BOX.  

class Solution {
    
    // FUNCTION TO FIND THE SUM OF THE GIVEN INTEGER.
    public int sumOfDigits(int val)
    {
        int sum = 0;
        
        while(val!=0)
        {
            sum += (val%10);
            val = val/10;
        }
        
        return sum;
    }
    
    public int countBalls(int lowLimit, int highLimit) 
    {
        int ballCount[] = new int[46];
        int ans = 0;
        
        // TRAVERSING FROM THE LOW LIMIT TO HIGH LIMIT.
        for(int i=lowLimit;i<=highLimit;i++)
        {
            int s = this.sumOfDigits(i);
            ballCount[s] += 1;
            
            if(ballCount[s] > ans)
            {
                ans = ballCount[s];
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*LOG N)
// SPACE COMPLEXITY : O(N)
