class Solution {
    
    public int sumOfDigits(int val)
    {
        int sum = 0;
        
        while(val!=0)
        {
            sum += (val%10);
            val = val/10;
        }
        
        return sum;
    }
    
    public int countBalls(int lowLimit, int highLimit) 
    {
        int ballCount[] = new int[46];
        int ans = 0;
        
        for(int i=lowLimit;i<=highLimit;i++)
        {
            int s = this.sumOfDigits(i);
            ballCount[s] += 1;
            
            if(ballCount[s] > ans)
            {
                ans = ballCount[s];
            }
        }
        
        return ans;
    }
}
