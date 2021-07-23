class Solution 
{
    public String thousandSeparator(int n) 
    {
        if(n == 0)
        {
            return "0";
        }
        
        String ans = "";
        int count = 0;
        
        while(n > 0)
        {
            ans = (n%10)+ans;
            count += 1;
            n = n/10;
            
            if(count == 3 && n > 0)
            {
                ans = "."+ans;
                count = 0;
            }
        }
        
        return ans;
    }
}
