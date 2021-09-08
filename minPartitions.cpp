// THE PROBLEM STATEMENT IS TO RETURN THE MINIMUM NUMBER OF POSITIVE DECI-BINARY NUMBERS NEEDED SO THAT THEY SUM UPTO N.
// A DECI-BINARY NUMBER IS AN INTEGER WHICH CONTAINS ONLY ONES AND ZEROS.
// I.E IF N = "32" THEN WE HAVE TO SPLIT IT AS 10+11+11, HENCE THE ANSWER IS 3.

// MY APPROACH IS TO FIND THE HIGHEST DIGIT IN THE THE GIVEN STRING OF DIGITS. THEN RETURN ITS VALUE.
// THE REASON BEING IS, IF YOU LOOK AT 32, WE CAN SPLIT IT AS 10+11+11 WHICH CONTAINS 3 NUMBERS, SINCE THE MAXIMUM DIGIT IS 3, AND
// WE ONLY HAVE TO USE DECI-BINARY NUMBERS, SO INORDER TO GET THE DIGIT THREE WE REQUIRE SUM OF THREE ONES, AND HENCE WE HAVE THREE DIFFERENT NUMBERS.

class Solution 
{
    public:
        int minPartitions(string n) 
        {
            int maxValue = -1;
            
            // TRAVERSING THE GIVEN STRING N.
            for(int i=0;i<n.size();i++)
            {
                int v = n[i]-'0';
                
                if(v > maxValue)
                {
                    maxValue = v;
                }
            }
            
            return maxValue;
        }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
