// THE PROBLEM STATEMENT IS TO PRINT THE MAXIMUM NUMBER OF BALANCED STRINGS PRESENT IN THE GIVEN STRING.
// THE GIVEN STRING ONLY CONTAINS 'L' AND 'R'. A BALANCED STRING IS ONE IN WHICH NUMBER OF CHARACTERS 'L' AND 'R' ARE EQUAL.

// MY APPROACH IS TO TRAVERSE THE GIVEN STRING AND CHECK IF IT IS 'L' OR 'R'. IF IT IS 'L' DECREMENT THE BALANCE COUNT ELSE INCREMENT THE BALANCE COUNT.
// IF THE BALANCE VALUE REACHES ZERO WE INCREMENT THE NO OF BALANCED STRING COUNT.

class Solution {
public:
    int balancedStringSplit(string s) {
        int balance = 0,noOfBalancedString = 0;
        
        // TRAVERSING THE GIVEN STRING.
        for(int i=0;i<s.size();i++)
        {
            if(s[i] == 'R')
            {
                balance += 1;
            }
            else if(s[i] == 'L')
            {
                balance -= 1;
            }
            
            if(balance == 0)
            {
                noOfBalancedString += 1;
            }
        }
        
        return noOfBalancedString;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
