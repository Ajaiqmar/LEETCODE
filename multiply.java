// THE PROBLEM STATEMENT IS TO RETURN THE PRODUCT OF THE GIVEN TWO INTEGERS REPRESENTED IN THE FORM OF STRING.

// MY APPROACH IS TO INITIALLY CHECK IF EITHER NUM1 OR NUM2 IS ZERO, IF IT IS RETURN "0" ELSE WE INITIALISE TWO FOR LOOP WHICH TRAVERSE 
// THE GIVEN TWO INTEGERS IN REVERSE, THEN MULTIPLY THE DIGITS IN THAT UNIT PLACE, THEN STORE THE VALUES INT THE INTEGERS ARRAY.
// FINALLY, TARVERSE THE THE INTEGER ARRAY IN REVERSE TO GET THE PRODUCT.

class Solution 
{
    public String multiply(String num1, String num2) 
    {
        String product = "";
        
        // CHECKING IF EITHER NUM1 IS EQUAL TO ZERO OR NUM2 IS EQUAL TO ZERO.
        if(num1.equals("0") || num2.equals("0"))
        {
            return "0";
        }
        
        int[] ans = new int[num1.length()+num2.length()];
        int len = 0;
        
        // TRAVERSING BOTH INTEGERS IN REVERSE.
        for(int i=num1.length()-1,k = 0;i>=0;i--,k++)
        {
            int val1 = num1.charAt(i)-'0';
            int carryOver = 0;
            int ind = k;
            
            for(int j=num2.length()-1;j>=0;j--)
            {
                int val2 = num2.charAt(j)-'0';
                
                ans[ind] += (val1*val2)+carryOver;
                carryOver = ans[ind]/10;
                ans[ind] = ans[ind]%10;
                ind += 1;
            }
            
            if(carryOver > 0)
            {
                ans[ind] = carryOver;
                ind += 1;
            }
            
            if(ind > len)
            {
                len = ind;
            }
        }
        
        for(int i=len-1;i>=0;i--)
        {
            product += ans[i];
        }
        
        return product;
    }
}

// TIME COMPLEXITY : O(N*M)
// SPACE COMPLEXITY : O(N+M)
