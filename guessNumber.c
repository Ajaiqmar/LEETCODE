int guessNumber(int n){
	int l=1,r=n;
    
    while(l<r)
    {
        int m = l+((r-l)/2);
        int v = guess(m);
        
        if(v==0)
        {
            return m;
        }
        else if(v==1)
        {
            l = m+1;
        }
        else if(v==-1)
        {
            r = m-1;
        }
    }
    
    return l;
}
