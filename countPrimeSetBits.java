class Solution {
    public static int countSetBits(int x)
    {
        int count = 0;
        
        while(x!=0)
        {
            if(x%2 == 1)
            {
                count++;
            }
            x= x/2;
        }
        
        return count;
    }
    
    public int countPrimeSetBits(int left, int right) 
    {
        int[] primes = {2,3,5,7,11,13,17,19,23,29,31};
        int ans = 0;
        
        for(int i=left;i<=right;i++)
        {
            if(Arrays.binarySearch(primes,countSetBits(i)) >= 0)
            {
                ans++;
            }
        }
        return ans;
    }
}
