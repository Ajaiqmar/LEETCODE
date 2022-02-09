// PROBLEM DESCRIPTION : https://leetcode.com/problems/k-diff-pairs-in-an-array/

// MY APPROACH IS TO USE AN HASHMAP AND STORE THE VALUES AND THE NUMBER OF OCCURRENCES IN THE ARRAY AS KEY AND VALUE PAIR. THEN TRAVERSE THE ARRAY AGAIN
// AND CHECK IF THE CURRENT VALUE PLUS K AND MINUS K EXISTS, IF IT DOES THEN WE INCREMENT THE ANSWER, WE ALSO HAVE TO MARK IT DOWN BECAUSE WE
// NEED THE COUNT OF UNIQUE PAIRS WHOSE ABSOLUTE DIFFERENCE IS K. THERE IS ALSO SPECIAL CASE WHERE K IS EQUAL TO 0 IF THAT'S THE CASE THEN WE HAVE TO CHECK THE 
// THE NUMBER OF OCCURRENCES OF THAT PARTICULAR VALUE, BEFORE INCREMNETING THE ANSWER.

class Solution 
{
    public int findPairs(int[] nums, int k) 
    {
        // INITIALISING THE HASHMAP.
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        int n = nums.length,ans = 0;
        
        // TRAVERSING THE ARRAY.
        for(int i=0;i<n;i++)
        {
            if(hashmap.get(nums[i]) == null)
            {
                hashmap.put(nums[i],1);
            }
            else
            {
                hashmap.put(nums[i],hashmap.get(nums[i])+1);
            }
        }
        
        // FINDING OUT THE UNIQUE PAIRS WHOSE ABSOLUTE DIFFERENCE IS EQUAL TO K.
        for(int i=0;i<n;i++)
        {
            if(hashmap.get(nums[i]) > 0 && k != 0)
            {

                if(hashmap.get(nums[i]-k) != null && hashmap.get(nums[i]-k) > 0)
                {
                    ans += 1;
                }
                
                if(hashmap.get(nums[i]+k) != null && hashmap.get(nums[i]+k) > 0)
                {
                    ans += 1;
                }
                
                hashmap.put(nums[i],-hashmap.get(nums[i]));
            }
            else if(hashmap.get(nums[i]) > 1)
            {
                ans += 1;
                hashmap.put(nums[i],-hashmap.get(nums[i]));
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
