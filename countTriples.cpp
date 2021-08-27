// THE PROBLEM STATEMENT IS TO RETURN THE COUNT OF TRIPLETS (A,B,C) WHERE (A*A) + (B*B) = (C*C).

// MY APPROACH IS TO APPLY THE FORMULA C = SQRT((A*A) + (B*B)) AND THEN CHECK WHETHER (A*A) + (B*B) = (C*C).
// INORDER TO APPLY THE INITIAL FORMULA WE REQUIRE TWO LOOPS FOR A AND B VALUES, THEN WE FIND C AND WE CHECK THE LATTER FORMULA IS TRUE.
// IF THE LATTER FORMULA IS TRUE, INCREMENT THE COUNT OF TRIPLES BY ONE.

class Solution {
public:
    int countTriples(int n) {
        int ans = 0;
        
        // CONSIDERING EVERY POSSIBLE PAIRS FOR THE A AND B VALUES.
        for (int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                int lhs = (i*i)+(j*j);
                int rhs = sqrt(lhs);
                
                if((rhs*rhs) == lhs && rhs <= n)
                {
                    ans += 1;
                }
            }
        }
        
        return ans;      
    }
};

// TIME COMPLEXITY : O(N*N*LOG N) LOG N REPRESENTS SQUARE ROOT FUNCTION THAT HAS BEEN APPLIED.
// SPACE COMPLEXITY : O(1)
