// PROBLEM DESCRIPTION : https://leetcode.com/problems/4sum-ii/

// MY APPROACH IS FIRSTLY FIND EVERY COMBINATION OF NUM1 AND NUM2 ARRAY AND STORE THOSE VALUES INTO AN HASHMAP, THEN CHECK IF THE NEGATION OF THE VALUES OF EVERY
// COMBINATION OF NUM3 AND NUM4 ARRAY IS PRESENT IN THE HASHMAP. IF IT IS PRESENT, THEN ADD THE VALUE TO THE ANSWER.

class Solution 
{
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) 
    {
        // INITIALISING A HASHMAP
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        int n = nums1.length,ans = 0;
        
        // GOING THROUGH EVERY COMBINATION OF NUM1 AND NUM2 ARRAY VALUES.
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(hashmap.get(nums1[i]+nums2[j]) == null)
                {
                    hashmap.put(nums1[i]+nums2[j],1);
                }
                else
                {
                    hashmap.put(nums1[i]+nums2[j],hashmap.get(nums1[i]+nums2[j])+1);
                }
            }
        }
        
        // GOING THROUGH EVERY COMBINATION OF NUM3 AND NUM4 ARRAY VALUES.
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(hashmap.get(-(nums3[i]+nums4[j])) != null)
                {
                    ans += hashmap.get(-(nums3[i]+nums4[j]));
                }
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N*N)
