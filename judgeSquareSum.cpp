// THE PROBLEM STATEMENT CHECK IF THERE EXIST AN INTEGERS A AND B SUCH THAT (A*A)+(B*B) = C. HERE THE C VALUE IS GIVEN.

// MY APPROACH IS TO TRAVERSE FROM 0 TO SQUARE ROOT OF C AND IN EACH ITERATION, CHECK WHETHER THE DIFFERENCE BETWEEN C AND SQUARE OF I IS A SQUARE NUMBER.

// THE REASON WE ONLY NEED TO TRAVERSE UNTIL SQUARE ROOT OF C IS, LET'S SAY THAT C = 4,
// SQUARE ROOT OF C = 2, THE VALUES ABOVE SQUARE ROOT OF C ARE INVALID BECAUSE THEIR SQUARE VALUE IS GREATER THAN THE GIVEN C. (I.E) 3*3 = 9.
// HENCE IT CANNOT BE CONSIDERED AS EITHER A OR B.

class Solution {
public:
    bool judgeSquareSum(int c) {
        
        // TRAVERSING FROM 0 TO SQUARE ROOT OF N.
        for(int i=0;i<=floor(sqrt(c));i++)
        {
            int b = c - (i*i);
            
            if(floor(sqrt(b)) == sqrt(b))
            {
                return true;
            }
        }
        
        return false;
    }
};

// TIME COMPLEXITY : O(LOG N * (LOG N + LOG N)) , THE TIME COMPLEXITY TO FIND THE SQUARE ROOT OF A NUMBER IS LOG N.
// SPACE COMPLEXITY : O(1)
