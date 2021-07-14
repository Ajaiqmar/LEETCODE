class Solution {
    public int rotatedDigits(int n) {
        int[] dp = new int[n+1];
        int ans = 0;
        
        for(int i=0;i<n+1;i++)
        {
            if(i<10)
            {
                if(i == 0 || i == 1 || i == 8)
                {
                    dp[i] = 1;
                }
                else if(i == 2 || i == 5 || i == 6 || i == 9)
                {
                    dp[i] = 2;
                    ans++;
                }
            }
            else
            {
                int a = dp[i%10], b = dp[i/10];
                if(a == 0 || b == 0)
                {
                    dp[i] = 0;
                }
                else if(a == 1 && b == 1)
                {
                    dp[i] = 1;
                }
                else
                {
                    dp[i] = 2;
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
