// THE PROBLEM STATEMENT IS TO RETURN THE MAXIMUM LENGTH OF A SUBSTRING WHICH CONTAINS ONLY ONE UNIQUE CHARACTERS.

// MY APPROACH IS TO USE MODIFIED KADANE ALGORITHM. FIRST, TRAVERSE THE STRING AND KEEP IN CHECK OF THE POWER AND MAXPOWER VALUES.
// THE MAXPOWER IS INITIALISED TO ONE INITIALLY SINCE, FOR ANY GIVEN STRING THE MINIMUM POWER WILL ALWAYS BE ONE. THEN WE TRAVERSE THE STRING AND CHECK AT EACH INDEX IF
// IT IS EQUAL TO THE PREVIOUS CHARACTER. IF IT IS THEN WE INCREMENT THE POWER ELSE WE RETURN IT TO THE INITIAL VALUE.

class Solution {
public:
    int maxPower(string s) 
    {
        // TRAVERSING THE GIVEN STRING TO FIND THE MAXIMUM POWER OF THE STRING.
        int power = 1,maxPower = 1;
        
        for(int i=1;i<s.size();i++)
        {
            if(s[i] == s[i-1])
            {
                power += 1;
            }
            else
            {
                power = 1;
            }
            
            if(power > maxPower)
            {
                maxPower = power;
            }
        }
    
        return maxPower;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
