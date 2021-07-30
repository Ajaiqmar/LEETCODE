// THE PROBLEM STATEMENT IS TO RETURN THE MAXIMUM NUMBER BY CHANGING ATMOST ONE DIGIT.
// THE GIVEN NUMBER WILL ONLY CONTAIN 6 OR 9.

// MY APPROACH IS TO ADD 3 TO THE FIRST OCCURRENCE OF 6 IN THE INTEGER.
// SO UNTIL 6 IS FOUND IN THE INTEGER INCREASE THE VAL BY THE POWER OF TEN, AND WHEN IT IS FOUND STORE THE VAL IN THE VALTOBEADDED VARIABLE.

class Solution {
public:
    int maximum69Number (int num) {
        int valToBeAdded = 0, val = 3;
        int temp = num;
        
        // LOOP OVER THE INTEGER DIGIT BY DIGIT TO FIND THE OCCURRENCE OF THE VALUE SIX.
        while(temp != 0)
        {
            if(temp%10 == 6)
            {
                valToBeAdded = val;
            }
            val = val*10;
            temp = temp/10;
        }
        
        return num+valToBeAdded;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
