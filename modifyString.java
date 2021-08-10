// THE PROBLEM STATEMENT IS TO RETURN MODIFIED STRING OF THE GIVEN STRING. THE GIVEN STRING CONTAINS LOWERCASE ENGLISH CHARACTERS AND QUESTION MARK CHARACTERS.
// THE MODIFIED STRING SHOULDN'T CONTAIN ANY QUESTION MARK CHARACTERS, THE QUESTION MARK CHARACTERS SHOULD BE REPLACED WITH LOWERCASE ENGLISH CHARACTERS, AND THE ADJACENT 
// CHARACTERS SHOULDN'T BE EQUAL.

// MY APPROACH IS TO TRAVERSE THE STRING AND WHENEVER A QUESTION MARK IS ENCOUNTERED, WE HAVE TO REPLACE IT WITH ANY ONE OF THE 26 LOWERCASE ENGLISH CHARACTERS
// WHICH AREN'T EQAUL TO THE ADJACENT CHARACTERS.

class Solution 
{
    public String modifyString(String s) 
    {
        
        StringBuilder ans = new StringBuilder();
        
        // CHECKING FOR THE EDGE CASES.
        if(s.length() == 1 && s.charAt(0) == '?')
        {
            ans.append('a');
            return ans.toString();
        }
        
        // TRAVERSING THE GIVEN STRING.
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '?')
            {
                for(int j=0;j<26;j++)
                {
                    if(i == 0 && s.charAt(i+1) != ('a'+j))
                    {
                        char x = (char)('a'+j);
                        ans.append(x);
                        break;
                    }
                    else if(i == (s.length()-1)  && ans.charAt(i-1) != ('a'+j))
                    {
                        char x = (char)('a'+j);
                        ans.append(x);
                        break;
                    }
                    else if(i > 0 && i < (s.length()-1) && s.charAt(i+1) != ('a'+j) && ans.charAt(i-1) != ('a'+j))
                    {
                        char x = (char)('a'+j);
                        ans.append(x);
                        break;
                    }
                }
            }
            else
            {
                ans.append(s.charAt(i));
            }
        }
        
        return ans.toString();
    }
}

// TIME COMPLEXITY : O(26*N) THIS WOULDN'T BE O(N*N) BECAUSE THE NUMBER OF LOWERCASE ENGLISH CHARACTERS IS A CONSTANT AND IT WOULDN'T GROW LINEARLY DEPENDING 
//                   UPON THE INPUTS.
// SPACE COMPLEXITY :O(N)
