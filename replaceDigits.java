class Solution {
    public static char shift(char c,int x)
    {
        return (char)(c+x);
    }
    
    public String replaceDigits(String s) {
        String ans = "";
        
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                char x = shift(s.charAt(i-1),s.charAt(i)-'0');
                ans = ans+x;
            }
            else
            {
                ans = ans+s.charAt(i);
            }
        }
        
        return ans;
    }
}
