// THE PROBLEM STATEMENT IS TO RETURN THE LONGEST PALINDROMIC SUBSTRING IN A GIVEN STRING.

// MY APPROACH IS TO TRAVERSE THE GIVEN STRING AND CONSIDER EACH CHARACTER OR EACH ADJACENT CHARACTER AS THE CENTER OF THE PALINDROMIC STRING,
// THEN EXPAND ITS LENGTH USING TWO POINTERS LEFT AND RIGHT, WHILE STRING[LEFT] == STRING[RIGHT]. ALSO, KEEP IN CHECK OF THE LENGTH, THEN RETURN THE LENGTH.
// CHECK THE RECEIVED LENGTH IS GREATER THAN THE MAX LENGTH, IF IT IS ASSIGN THE RECEIVED LENGTH TO THE MAX LENGTH.
// THEN, RETURN THE SUBSTRING.

class Solution 
{
    // FUNCTION TO CHECK IF THE GIVEN CHARACTERS ARE THE CENTER IF A PALINDROME.
    public static int checkPalindrome(String s,int l,int r)
    {
        int len = 0;
        
        if(l == r)
        {
            len = 1;
            l -= 1;
            r += 1;
        }
        else if(s.charAt(l) == s.charAt(r))
        {
            len = 2;
            l -= 1;
            r += 1;
        }
        
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
        {
            len += 2;
            l -= 1;
            r += 1;
        }
        
        return len;
    }
    
    public String longestPalindrome(String s) 
    {
        if(s.length() == 1)
        {
            return s;
        }
        
        int start = -1,end = -1,maxLength = 0;
        
        // TRAVERSING THE GIVEN STRING.
        for(int i=0;i<s.length()-1;i++)
        {
            int len1 = checkPalindrome(s,i,i);
            int len2 = checkPalindrome(s,i,i+1);
            
            if(len1 > maxLength)
            {
                maxLength = len1;
                start = i-(len1/2);
                end = i+(len1/2);
            }
            
            if(len2 > maxLength)
            {
                maxLength = len2;
                start = i-((len2/2)-1);
                end = (i+1)+((len2/2)-1);
            }
        }
        
        return s.substring(start,end+1);
    }
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)
