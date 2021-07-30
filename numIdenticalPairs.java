// THE PROBLEM STATEMENT IS TO COUNT THE NUMBER OF GOOD PAIRS WHERE BOTH THE ELEMENTS OF THE PAIR ARE EQUAL. 
// I.E. NUMS[I] == NUMS[J] && I < J

// MY APPROACH IS TO STORE THE DIGITS AND THE NUMBER OF OCCURRENCE OF THE DIGITS IN THE HASHMAP, THEN IF THE NUMBER OF OCCURRENCE IS GREATER THAN ONE
// INCREMENT THE ANS BY NUMBER OF OCCURRENCE MINUS ONE.

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int ans = 0;
        
        // LOOP OVER THE ARRAY AND STORE THE VALUES INTO HASHMAP.
        for(int i=0;i<nums.length;i++)
        {
            if(hm.get(nums[i]) != null)
            {
                hm.put(nums[i],hm.get(nums[i])+1);
                ans += (hm.get(nums[i])-1);
                // INCREMENT THE ANS VALUE
            }
            else
            {
                hm.put(nums[i],1);
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
