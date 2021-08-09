// THE PROBLEM STATEMENT IS TO CHECK IF THE GIVEN STRING IS A PREFIX STRING.
// A PREFIX STRING IS ONE WHICH CAN BE OBTAINED BY APPENDING THE FIRST K STRINGS IN THE WORDS ARRAY OF LENGTH N

// MY APPROACH IS TO TRAVERSE THE WORDS ARRAY AND APPEND EACH STRING TO THE PREFIX STRING THEN CHECK IF IT IS EQUAL TO THE 
// GIVEN STRING. IF IT IS RETURN TRUE, ELSE FALSE.

class Solution 
{
    public boolean isPrefixString(String s, String[] words) 
    {
        String prefixString = "";
        
        // TARVERSING THE WORDS ARRAY OF LENGTH.
        for(int i=0;i<words.length;i++)
        {
            prefixString += words[i];
            
            if(prefixString.equals(s))
            {
                return true;
            }
        }
        return false;
    }
}

// TIME COMPLEXITY : O(M*N*N) WHERE M IS THE LENGTH OF THE WORDS ARRAY AND N IS THE LENGTH OF THE STRINGS TO BE APPENDED.
// APPARENTLY, IT TAKES O(N*N) TO APPEND TWO STRINGS, SO IF YOU WANT TO BE EVEN MORE EFFICIENT, YOU COULD USE STRING BUILDER .

// SPACE COMPLEXITY : O(N);
