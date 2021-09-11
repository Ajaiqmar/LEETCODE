// THE PROBLEM STATEMENT IS TO CONVERT THE GIVEN INTEGER TO ROMAN NUMERAL.

// MY APPROACH IS TO KEEP ALL THE ROMAN NUMERAL SYMBOLS AS A STRING, THEN TRAVERSE EACH DIGIT USING A WHILE LOOP, FOR EACH DIGIT CHECK IF IT
// IS EITHER FOUR OR NINE, IF IT IS FOUR ADD THE CHARACTER AT THE CURRENT INDEX AND THEN ADD THE NEXT CHARACTER INTO THE UNIT PLACE STRING.
// ELSE IF IT IS NINE, ADD THE CHARACTER AT THE CURRENT INDEX AND THEN ADD THE CHARACTER AT IND+2 INTO THE UNIT PLACE STRING.
// ELSE IF IT IS NOT FOUR OR NINE, CHECK WHETHER THE GIVEN VALUE IS GREATER THAN OR EQUAL TO FIVE, IF IT ADD THE CHARACTER AT IND+1 TO THE UNIT PLACE STRING,
// THEN ADD CHARACTER AT CURRENT INDEX FOR THE RESIDUAL COUNT. AT EACH TRAVERSAL INCREASE THE IND VALUE BY TWO. REPEAT THE SAME FOR EACH DIGIT IN THE GIVEN INTEGER. 

class Solution 
{
    public String intToRoman(int num) 
    {
        String ans = "";
        String symbols = "IVXLCDM";
        int ind = 0;
        
        // TRAVERSING EACH DIGIT IN THE GIVEN INTEGER.
        while(num > 0)
        {
            int val = num%10;
            String unitPlace = "";
            
            if(val == 4)
            {
                unitPlace += symbols.charAt(ind);
                unitPlace += symbols.charAt(ind+1);
            }
            else if(val == 9)
            {
                unitPlace += symbols.charAt(ind);
                unitPlace += symbols.charAt(ind+2);
            }
            else
            {
                if(val/5 == 1)
                {
                    unitPlace += symbols.charAt(ind+1);
                    val = val%5;
                }
                
                while(val > 0)
                {
                    unitPlace += symbols.charAt(ind);
                    val -= 1;
                }
            }
            
            ans = unitPlace+ans;
            num = num/10;
            ind += 2;
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(LOG N), THE SECOND WHILE LOOP RUNS FOR A MAXIMUM OF 3 TIMES, HENCE IT CAN BE CONSIDERED O(1) COMPLEXITY.
// SPACE COMPLEXITY : O(N)
