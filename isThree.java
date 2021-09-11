// THE PROBLEM STATEMENT IS TO CHECK WHETHER THE GIVEN INTEGER HAS EXACTLY 3 DIVISORS.

// MY APPROACH IS BASED ON THE FACT THAT EVERY SQUARE OF PRIME NUMBER HAS EAXCTLY THREE DIVISORS. SO, WE FIND THE SQUARE ROOT OF N AND CHECK WHETHER IT IS
// A PRIME NUMBER, IF IT IS RETURN TRUE, ELSE IF ANY OF THE CONDITION FAILS, RETURN FALSE.

class Solution {
    public boolean isThree(int n) {
        
        if(n == 1)
        {
            return false;
        }
        
        // FINDING SQUARE ROOT OF N
        double v = Math.sqrt(n);
        
        if(v == Math.floor(v))
        {
            // CHECKING IF SQUARE ROOT OF N IS A PRIME NUMBER. 
            for(int i=2;i<Math.floor(v);i++)
            {
                if(v%i == 0)
                {
                    return false;
                }
            }
            
            return true;
        }
        
        return false;
    }
}

// TIME COMPLEXITY : O(MAX(LOG N, SQRT(N))) ,IT TAKES LOG N COMPLEXITY TO FIND THE SQUARE ROOT OF A NUMBER, THEN WE ARE TRAVERSING SQRT(N) TIMES TO CHECK IF
//                   IT IS A PRIME NUMBER.
// SPACE COMPLEXITY : O(1)
