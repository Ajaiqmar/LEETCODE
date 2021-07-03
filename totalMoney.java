// NOT SO BETTER APPROACH

class Solution {
    public int totalMoney(int n) {
        int week = n/7;
        int ans = 0;
        
        for(int i=0;i<week;i++)
        {
            ans += ((i+4)*7);
        }
        
        int days = n%7;
        
        while(days>0)
        {
            ans += (week+1);
            week+=1;
            days-=1;
        }
        
        return ans;
    }
}

// BETTER APPROACH

class Solution {
    public int totalMoney(int n) {
        int week = n/7;
        int ans = 0;
        
        for(int i=0;i<week;i++)
        {
            ans += ((i+4)*7);
        }
        
        int days = n%7;
        
        while(days>0)
        {
            ans += (week+1);
            week+=1;
            days-=1;
        }
        
        return ans;
    }
}
