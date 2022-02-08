// PROBLEM DESCRIPTION : https://leetcode.com/problems/number-of-visible-people-in-a-queue/

// MY APPROACH IS TO USE A STACK DATA STRUCTURE TO FIND THE NUMBER OF PEOPLE IS VISISBLE TO A PERSON TOWARDS THE PERSONS RIGHT. WHILE TRAVERSING, WE WILL
// REMOVE ALL THE ELEMENTS AT THE TOP OF THE STACK WHEN THE CURRENT HEIGHT OF THE PERSON IS GREATER THAN OR EQUAL TO THE PERSON'S HEIGHT AT THE TOP OF THE STACK UNTIL THE
// STACK BECOMES EMPTY OR THE CONDITION BECOMES FALSE. THEN IF THE STACK IS EMEPTY WE ASSIGN THE COUNT OF PEOPLE WE POPPED OUT OF THE STACK TO ANSWER ARRAY ELSE IF THE 
// CONDITION HAD FAILED WHICH MEANS THERE IS ONE OTHER PERSON WHO IS VISIBLE, SO WE INCREMENT THE COUNT OF PEOPLE THAT IS VISIBLE THEN WE ASSIGN IT TO THE ARRAY.
// FINALLY RETURN THE ARRAY.

class Solution 
{
    public int[] canSeePersonsCount(int[] heights) 
    {
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        
        // TRAVERSING THE GIVEN HEIGHTS ARRAY.
        for(int i=(n-1);i>=0;i--)
        {
            int noOfVisiblePeople = 0;
            
            // POPPING OUT ALL THE PEOPLE HEIGHT WHOSE HEIGHT IS LESSER THAN OR EQUAL TO THE CURRENT HEIGHT.
            while(stack.size() != 0 && heights[i] >= stack.peek())
            {
                noOfVisiblePeople += 1;
                stack.pop();
            }
            
            if(stack.size() == 0)
            {
                ans[i] = noOfVisiblePeople;
            }
            else
            {
                ans[i] = noOfVisiblePeople+1;
            }
            
            stack.push(heights[i]);
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
