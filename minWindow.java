// THE PROBLEM STATEMENT IS TO RETURN MINIMUM WINDOW SUBSTRING WHICH CONTAINS ALL THE CHARACTERS THAT ARE PRESENT IN THE GIVEN STRING T.

// MY APPROACH IS TO FIRSTLY CHECK THAT THE STRING S LENGTH IS GREATER THAN THAT OF STRING T, THEN INITIALISE TWO HASHTABLES ONE OF WHICH WILL CONTAIN THE NUMBER
// OF OCCURRENCE OF CHARACTERS IN THE STRING T AND THE OTHER ONE WILL CONTAIN THE NUMBER OF OCCURRENCE OF THE CHARACTERS IN THE SLIDING WINDOW.
// INITIALLY WE WILL TAKE THE SLIDING WINDOWS LENGTH AS STRING T'S LENGTH, THEN WE WILL TRVERSE THE REST OF THE STRING S, FIRST WE WILL CHECK IF THE GIVEN
// SUBSTRING CONTAINS THE ALL CHARACTERS PRESENT IN THE GIVEN STRING T, IF IT IS PRESENT, THEN WE WILL MOVE IN THE SLIDING WINDOW POINTER UNTIL IT DOESN'T
// CONTAIN ALL THE CHARACTERS IN THE STRING T AND WHILE DOING SO KEEP IN CHECK OF THE LENGTH OF THE SUBSTRING, COMPARE IT WITH CURRENT
// MINIMUM LENGTH, AND NOTE DOWN THE STARTING AND ENDING INDEX.

class Solution 
{
    public String minWindow(String s, String t) 
    {
        if(s.length() < t.length())
        {
            return "";
        }
        
        // INITIALISING THE HASHTABLE.
        int[] hashtable1 = new int[128];
        int[] hashtable2 = new int[128];
        
        // TRAVERSING THE GIVEN STRING T.
        for(int k=0;k<t.length();k++)
        {
            hashtable1[t.charAt(k)] += 1;
            hashtable2[s.charAt(k) ] += 1;
        }
        
        int i=0,j=t.length();
        int ml = Integer.MAX_VALUE,mi = -1,mj = -1;
        
        // PERFORMING THE SLIDING WINDOW FUNCTION TO FIND THE MINIMUM WINDOW SUBSTRING.
        while(j <= s.length())
        {
            Boolean flag = true;
            
            for(int k=0;k<128;k++)
            {
                if(hashtable2[k] >= hashtable1[k])
                {
                    continue;
                }
                else
                {
                    flag = false;
                    break;
                }
            }
            
            if(!flag)
            {
                if(j == s.length())
                {
                    break;
                }
                
                hashtable2[s.charAt(j)] += 1;
                j += 1;
                continue;
            }
            
            while(flag)
            {
                if(flag && ml > ((j-i)+1))
                {
                    ml = (j-i)+1;
                    mi = i;
                    mj = j;
                }
                
                hashtable2[s.charAt(i)] -= 1;
                i += 1;
                
                for(int k=0;k<128;k++)
                {
                    if(hashtable2[k] >= hashtable1[k])
                    {
                        continue;
                    }
                    else
                    {
                        flag = false;
                        break;
                    }
                }
            }
        }
        
        if(ml == Integer.MAX_VALUE)
        {
            return "";
        }
        
        String ans = "";
        for(int k=mi;k<mj;k++)
        {
            ans += s.charAt(k);
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(M+N) AT ANY GIVEN ITERATION INSIDE THE WHILE LOOP, WE WILL EITHER BE MOVING THE LEFT POINTER OR THE RIGHT POINTER.
// SPACE COMPLEXITY : O(1) SINCE THE HASHTABLES SIZE DOEN'T GROW LINEARLY.
