// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF UNIQUE MAIL IDS PRESENT IN THE ARRAY OF EMAIL IDS.
// BEFORE CONSIDERING EACH EMAIL ID AS VALID, WE NEED TO CLEAN IT BY FOLLOWING THE GIVEN PROCEDURES. AN EMAIL ID CONSIST OF A LOCAL NAME AND A DOMAIN NAME
// SPERATED BY A '@'. THE EMAIL ID MAY ALSO CONTAIN '+' AND '.'. IF THERE IS A '.' CHARACTER IN THE LOCAL NAME OF THE EMAIL ID, WE HAVE TO IGNORE IT,
// BUT NOT IN THE DOMAIN NAME. IF THERE IS A '+' CHARACTER IN THE LOCAL NAME, WE HAVE TO SKIP THE REST OF THE GIVEN CHARACTERS IN THE LOCAL NAME.

// MY APPROACH IS TO FIRST TRAVERSE THE ARRAY OF STRINGS AND START CLEANING EACH EMAIL ID PRESENT IN THAT ARRAY USING THE ABOVE CONDITIONS.
// THEN WE HAVE TO CHECK IF IT IS A UNIQUE ONE, IF IT IS THEN INCREMENT THE NUMBER OF UNIQUE EMAIL ADDRESS.

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<String>();
        
        // TRAVERSING THE ARRAY OF EMAIL IDS.
        for(int i=0;i<emails.length;i++)
        {
            StringBuilder email = new StringBuilder();
            Boolean flag = true,atFlag = false;
            
            // TRAVERSING EACH CHARACTERS OF THE EMAIL IDS TO CLEAN THEM.
            for(int j=0;j<emails[i].length();j++)
            {
                if(atFlag)
                {
                    email.append(emails[i].charAt(j));
                }
                else if(flag && emails[i].charAt(j) != '@')
                {
                    if(emails[i].charAt(j) == '.')
                    {
                        continue;
                    }
                    else if(emails[i].charAt(j) == '+')
                    {
                        flag = false;
                        continue;
                    }
                    else
                    {
                        email.append(emails[i].charAt(j));
                    }
                }
                
                if(emails[i].charAt(j) == '@')
                {
                    email.append(emails[i].charAt(j));
                    atFlag = true;
                }
            }
            
            hs.add(email.toString());
        }
        return hs.size();
    }
}

// TIME COMPLEXITY : O(N*M) WHERE M IS THE LENGTH OF THE STRINGS
// SPACE COMPLEXITY : O(N)
