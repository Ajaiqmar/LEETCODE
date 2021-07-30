// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF STAIRCASES THAT CAN BE BUILD USING THE GIVEN COINS. THE STAIRCASE CONSISTS OF K ROWS AND I-TH ROW CONTAINS
// EXACTLY I GOLD COINS. THE LAST ROW OF STAIR CASE MAY OR MAY NOT BE INCOMPLETE.

// MY APPROACH IS TO USE THE EXHAUSTIVE APPROACH.

// FOLLOW - UP : BUT THIS PROBLEM CAN ALSO BE SOLVED USING BINARY SEARCH APPROACH. THERE IS A DOWNSIDE THAT IF THE VALUE IS HIGHER THAN IT CANNOT DEDUCE
// THE VALUE. THE GIVEN CONSTRAINT IS (2^31)-1. SO IT IS NOT POSSIBLE TO USE THIS APPROACH.

// EXHAUSTIVE SEARCH

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

// BINARY SEARCH

int arrangeCoins(int n)
{
    int left = 1,right = n;
    
    while(left <= right)
    {
        int mid = left+((right-left)/2);
        int val = (mid*(mid+1))/2;
        if(val == n)
        {
            return mid;
        }
        else if(val < n)
        {
            left = mid+1;
        }
        else if(val > n)
        {
            right = mid-1;
        } 
    }
    
    return right;
}




// EXHAUSTIVE SEARCH
// TIME COMPLEXITY : O(K) WHERE K IS THE NUMBER OF STAIRS.
// SPACE COMPLEXITY : O(1)

// BINARY SEARCH
// TIME COMPLEXITY : O(LOG N)
// SPACE COMPLEXITY : O(1)
