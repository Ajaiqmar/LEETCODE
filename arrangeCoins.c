int arrangeCoins(int n){
    int ans = 0,v = 1;
    
    while(n!=0)
    {
        n -= v;
        v += 1;
        if(n>=0)
        {
            ans += 1;
        }
        else
        {
            n = 0;
        }
    }
    
    return ans;
}
