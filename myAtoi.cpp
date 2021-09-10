// THE PROBLEM STATEMENT IS TO CONVERT THE GIVEN DIGIT STRING INTO AN INTEGER.
// THE RULES ARE THAT THERE SHOULD BE NO LEADING WHITESPACES , THE VALUES CAN EITHER BE NEGATIVE OR POSITIVE DEPENDING UPON THE LEADING '+' OR '-' SYMBOL,
// WHEN TRAVERSING THE DIGITS, IF WE ENCOUNTER ANY OTHER CHARACTER OTHER THAN DIGITS WE SHOULD IGNORE THE REST OF THJE DIGITS AND IF THE INTEGER VALUE EXCEEDS
// THE 32-BIT SIGNED INTEGER RANGE [-2^31, 2^31 - 1], THEN CLAMP THE INTEGER SO THAT IT REMAINS IN THE RANGE.

// MY APPROACH IS TO USE A LONG INTEGER VARIABLE TO STORE THR INTEGER VALUE, SO THAT WE WILL ALSO BE ABLE TO CHECK IF THE VALUES EXCEEDS 32-BIT INTEGER RANGE,
// NOW, USE A WHILE LOOP TO REMOVE THE TRAILING ZEROS, THEN CHECK FOR '+' OR '-' CHARACTER, IF NOT PRESENT CONSIDER IT AS AN POSITIVE INTEGER.
// NOW TRAVERSE THE DIGITS AND ADD THEM TO THE ANS UNTIL THE INDEX IS LESS THAN THE STRING SIZE AND IT DOES NOT ENCOUNTER ANY OTHER CHARACTER OTHER THAN DIGITS.
// ALSO CHECK WHETHER THE VALUE HAS EXCEEDED THE 32-BIT INTEGER RANGE [-2^31, 2^31 - 1]. IF DID RETURN THEIR CORRESPONDING MAX OR MIN VALUE.
// IF IT PASSES ALL THE ABOVE CONDITION RETURN THE ANS VALUE.

class Solution {
public:
    int myAtoi(string s) {
        long long int ans = 0;
        int i = 0,minusFlag = 0;
        
        // REMOVING THE LEADING ZEROS.
        while(s[i] == ' ')
        {
            i += 1;
        }
        
        if(s[i] == '+')
        {
            i += 1;
        }
        else if(s[i] == '-')
        {
            minusFlag = 1;
            i += 1;
        }
        
        // TRAVERSING THE DIGITS.
        while(s[i] >= '0' && s[i] <= '9' && i < s.size())
        {
            ans = (ans*10)+(s[i]-'0');
            i += 1;
            
            if(ans > INT_MAX && minusFlag == 0)
            {
                return INT_MAX;
            }
            else if(-ans < INT_MIN)
            {
                return INT_MIN;
            }
        }
        
        if(minusFlag)
        {
            return -ans;
        }
        
        return ans;
    }
};

// TIME COMPLEXITY : O(N) WHERE N IS THE LENGTH OF THE GIVEN STRING.
// SPACE COMPLEXITY : O(1)

