// THE PROBLEM STATEMENT IS TO FIND NUMBER OF CONTIGOUS SUB-ARRAY SUM WHICH ARE EQUAL TO THE VALUE K.

// MY APPROACH IS TO USE PREFIX SUM ALONG WITH THE HASHMAP DATA STRUCTURE TO FIND THE NUMBER OF CONTIGOUS SUB-ARRAY WHOSE SUM IS EQUAL TO K.
// FIRST, WE FIND THE PREFIX SUM OF THE GIVEN ARRAY, PREFIX SUM IS AN ARRAY WHERE EACH INDEX VALUE IS THE SUM OF ALL INTEGERS TO THE LEFT OF THAT INDEX.
// WHILE INITIALISING THE PREFIX SUM ARRAY, WE WILL BE INSERTING THE VALUES ONTO THE HASHMAP AS WELL WITH VALUE AS THE KEY AND THE NUMBER OF OCCURRENCES AS THE
// VALUE. SECONDLY, WE TRAVERSE THE ARRAY AGAIN, NOW AT EACH INDEX WE FIND VAL WHICH IS EQUAL TO PREFIXSUM[I] + (K-NUMS[I]) WHERE NUMS IS THE GIVEN ARRAY.
// THEN, WE CHECK IF THE VALUE IS PRESENT IN THE HASHMAP, IF IT IS WE ADD THE NUMBER OF OCCURRENCE TO THE ANS VARIABLE. FINALLY, WE REDUCE THE HASHMAP'S VALUE
// WHOSE KEY IS THE INTEGER AT THE CURRENT INDEX. THE ANS VARIABLE IS THE NUMBER OF CONTIGOUS SUB-ARRAY SUM WHICH ARE EQUAL TO THE VALUE K.

class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        // DECALRING AND INITIALISING THE HASHMAP.
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        int[] prefixSum = new int[nums.length];
        int ans = 0;
        
        prefixSum[0] = nums[0];
        hashmap.put(prefixSum[0],1);
        
        // INITIALISING THE PREFIX SUM ARRAY.
        for(int i=1;i<nums.length;i++)
        {
            prefixSum[i] = prefixSum[i-1]+nums[i];
            
            if(hashmap.get(prefixSum[i]) == null)
            {
                hashmap.put(prefixSum[i],1);
            }
            else
            {
                hashmap.put(prefixSum[i],hashmap.get(prefixSum[i])+1);
            }
        }
        
        // FINDING THE NUMBER OF CONTIGOUS SUBARRAYS WHOSE SUM IS K.
        for(int i=0;i<nums.length;i++)
        {
            int val = prefixSum[i] + (k-nums[i]);
            
            if(hashmap.get(val) != null)
            {
                ans += hashmap.get(val);
            }
            
            hashmap.put(prefixSum[i],hashmap.get(prefixSum[i])-1);
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
