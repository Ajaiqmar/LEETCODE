int getLucky(char * s, int k)
{
    int ans = 0;
    
    for(int i=0;i<strlen(s);i++)
    {
        int val = s[i]-'a'+1;
        if(val > 9)
        {
            ans += ((val%10)+(val/10));
        }
        else
        {
            ans += val;
        }
    }
    
    while(k>1)
    {
        if(ans<10)
        {
            break;
        }
        
        int val = 0;
        
        while(ans > 0)
        {
            val += (ans%10);
            ans = ans/10;
        }
        ans = val;
        
        k--;
    }
    
    return ans;
}
