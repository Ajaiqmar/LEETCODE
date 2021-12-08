// THE PROBLEM STATEMENT IS TO REVERSE THE PREFIX IN THE GIVEN STRING. A PREFIX IS DEFINED AS A SUBSTRING FROM INDEX 0 TO THE INDEX WHERE THE GIVEN CHARACTER
// FIRST OCCURRED. IF THE GIVEN CHARACTER IS NOT PRESENT IN THE STRING, RETURN THE STRING WITHOUT ANY MODIFICATION, ELSE REVERSE THE PREFIX AND THEN RETURN THE STRING.

// MY APPROACH IS FIRST PIPOINT THE GIVEN CHARACTERS INDEX, IF THE IT IS PRESENT IN THE GIVEN STRING. THEN USE TWO POINTER APPROACH TO REVERSE THE
// THE PREFIX IN THE GIVEN STRING AND THEN REVERSE THE STRING.

class Solution 
{
    public String reversePrefix(String word, char ch) 
    {
        int ind = 0;
        // SEARCHING FOR THE GIVEN CHARACTER.
        while(ind < word.length() && word.charAt(ind) != ch)
        {
            ind += 1;
        }
        
        if(ind == word.length())
        {
            return word;
        }
        
        char[] arr = word.toCharArray();
        int slind = 0;
        
        // USING TWO POINTER APPROACH TO REVERSE THE STRING.
        while(slind < ind)
        {
            char temp = arr[slind];
            arr[slind] = arr[ind];
            arr[ind] = temp;
            slind += 1;
            ind -= 1;
        }
        
        return new String(arr);
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE LENGTH OF THE STRING.
// SPACE COMPLEXITY : O(N) SINCE STRING MUTATION IS NOT POSSIBLE IN JAVA, SO WE HAVE TO USE CHARACTER ARRAY.
