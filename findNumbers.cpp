// THE PROBLEM STATEMENT IS TO FIND THE NUMBER OF INTEGERS WHICH CONTAINS EVEN DIGITS.

// MY APPROACH IS TO TRAVERSE THE ARRAY AND FIND THE FLOOR OF LOG TO THE BASE 10 OF EACH INTEGER. IF THE VALUE IS NOT EVEN THEN IT CONTAINS EVEN DIGITS.

class Solution 
{
public:
    int findNumbers(vector<int>& nums) 
    {
        int evenNumberOfDigits = 0;
        
        // TRAVERSING THE GIVEN ARRAY TO CALCULATE NUMBER OF EVEN NUMBER DIGITS. 
        for(int i=0;i<nums.size();i++)
        {
            // INVOKING THE FLOOR AND LOG BASE 10 FUNCTION.
            int exp = floor(log10(nums[i]));
            
            if(exp%2 != 0)
            {
                evenNumberOfDigits++;
            }
        }
        
        return evenNumberOfDigits;
    }
};

// TIME COMPLEXITY : O(N LOG N)
// SPACE COMPLEXITY : O(1)
