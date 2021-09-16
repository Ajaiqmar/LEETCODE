// THE PROBLEM STATEMENT IS TO CARRY OUT THE MYPOW FUNCTION WHITHOUT USING ANY BUILT-IN LIBRARY FUNCTION.

// MY APPROACH IS TO USE THE RECURSION TREE. WHEN TO USE RECURSION TREE IS, IF WE WANT CARRY OUT THE SAME FUNCTION N TIMES AND IF THE CONSTRAINTS ARE BIGGER,
// IT IS IDEAL TO USE RECURSION TREE. NOW, REGARDING FINDING X^N, WE NEED TO CALL THE RECURSIVE FUNCTION POWER,
// IN THE POWER FUNCTION, IF N == 0 RETURN 1 ELSE IF N IS EVEN RETURN THE SQUARE OF THE VALUE RETURNED WHEN CALLING THE POWER FUNCTION WHERE THE PARAMETER
// N IS DIVIDED BY 2. ELSE IF N IS ODD RETURN X TIMES THE SQUARE OF THE VALUE RETURNED WHEN CALLING THE POWER FUNCTION WHERE THE PARAMETER
// N IS DIVIDED BY 2.

// I.E. IF X = 2 AND N = 10
// THEN THE RECURSION TREE WILL LOOK LIKE:
//                POWER(2,10)           SINCE N IS ODD, WE HAVE TO RETURN POWER(X,N/2)*POWER(X,N/2)
//                /         \
//            POWER(2,5)    POWER(2,5)  SINCE N IS ODD, WE HAVE TO RETURN X*POWER(X,N/2)*POWER(X,N/2)
//             /       \
//        POWER(2,2)   POWER(2,2)
//           /     \
//    POWER(2,1)   POWER(2,1)

class Solution 
{
    // FUNCTION TO FIND X^N USING RECURSION TREE.
    public static double power(double x,int n)
    {
        if(n == 0)
        {
            return 1;
        }
        else if(n > 0)
        {
            double t = power(x,n/2);
            if(n%2 == 0)
            {
                return t*t;
            }
            else
            {
                return x*t*t;
            }
        }
        else
        {
            double t = power(x,n/2);
            if(n%2 == 0)
            {
                return t*t;
            }
            else
            {
                return x*t*t;
            }
        }
    }
    
    public double myPow(double x, int n) 
    {
        if(n < 0)
        {
            return power(1.0/x,n);
        }
        return power(x,n);
    }
}

// TIME COMPLEXITY : O(LOG N)
// SPACE COMPLEXITY : O(1)
