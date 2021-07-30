// THE PROBLEM STATEMENT IS TO MAP THE STRING TO LOWERCASE ENGLISH ALPHABETS FROM THE GIVEN STRING.
// THE GIVEN STRING WILL CONTAIN ONLY DIGITS AND POUND SIGN.
// THE ALPHABETS SHOULD FROM 'A' TO 'I' SHOULD MAP TO DIGITS '1' TO '9' AND FROM 'J' TO 'Z' SHOULD MAP TO ITS POSITION FOLLOWED BY THE POND SIGN. I.E: 10# = 'J'.

// MY APPROACH IS TO TRAVERSE FROM REVERSE AND WHENEVER A POUND SIGN IS ENCOUNTERED REDUCE THE INDEX VALUE BY 3 ANS THEN MAP TO ITS CORRESPONDING VALUE
// AND WHENEVER A SINGLE DIGIT IS ENCOUNTERED MAP TO IS CORRESPONDING VALUE.

class Solution 
{
    public String freqAlphabets(String s) 
    {
        String mappedString = "";
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int index = s.length()-1;
        
        // LOOP THE STRING BACKWARDS
        while(index>=0)
        {
            int alphabetIndex = 0;
            // CHECK FOR THE ALPHABET INDEX IN THE GIVEN STRING.
            if(s.charAt(index) == '#')
            {
                alphabetIndex = ((s.charAt(index-2)-'0')*10)+(s.charAt(index-1)-'0');
                mappedString = alphabets.charAt(alphabetIndex-1)+mappedString;
                index -= 3;
            }
            else
            {
                alphabetIndex = (s.charAt(index)-'0');
                mappedString = alphabets.charAt(alphabetIndex-1)+mappedString;
                index -= 1;
            }
        }
        
        return mappedString;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N) , BECAUSE STRING IS AN ARRAY OF CHARACTERS.
