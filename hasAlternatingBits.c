bool hasAlternatingBits(int n)
{
    int prevBit = n&1;
    n = n>>1;
    
    while(n > 0)
    {
        if((n&1) == prevBit)
        {
            return false;
        }
        prevBit = n&1;
        n = n>>1;
    }
    
    return true;
}
