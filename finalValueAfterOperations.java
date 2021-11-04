// THE PROBLEM STATEMENT IS TO RETURN THE VALUE OF X AFTER CARRYING OUT ALL THE OPERATIONS IN THE OPERATIONS STRING ARRAY. THE ARRAY CONTAINS ONLY FOUR
// OPERATIONS, THEY ARE : "++X","X++","X--","--X". INITIAL VALUE OF X IS 0.

// MY APPROACH IS TO TRAVERSE THE STRING ARRAY, CHECK THE SECOND CHARACTER OF EACH STRING AND CHECK IF THE CHARACTER IS '+' OR '-', DEPENDING UPON THAT
// INCREMENT OR DECREMENT THE VALUE RESPECTIVELY.

class Solution 
{
    public int finalValueAfterOperations(String[] operations) 
    {
        int ans = 0;
        // TRAVERSING THE OPERATIONS ARRAY TO FIND THE FINAL VALUE OF X.
        for(int i=0;i<operations.length;i++)
        {
            if(operations[i].charAt(1) == '+')
            {
                ans += 1;
            }
            else
            {
                ans -= 1;
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
