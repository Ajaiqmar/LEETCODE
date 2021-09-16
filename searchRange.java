// THE PROBLEM STATEMENT IS TO RETURN THE FIRST AND LAST OCCURRING INDEX OF THE GIVEN TARGET IN THE GIVEN SORTED ARRAY NUMS. IF THE TARGET IS NOT PRRSENT
// IN THE ARRAY RETURN [-1,-1].
// FOLLOW UP QUESTION IS TO FIND FIRST AND LAST OCCURING INDEX IN LOG N TIME COMPLEXITY.

// MY APPROACH IS TO USE THE BINARY SEARCH TO FIND THE FIRST AND THE LAST OCCURING INDEX OF THE GIVEN TARGET IN THE GIVEN SORTED ARRAY.

class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int l = 0,r = (nums.length-1);
        
        // BINARY SEARCH TO FIND THE FIRST OCCURRING INDEX.
        while(l <= r)
        {
            int m = l+((r-l)/2);
            
            if(nums[m] == target && (m == 0 || nums[m-1] != target))
            {
                ans[0] = m;
                break;
            }
            else if(nums[m] < target)
            {
                l = m+1;
            }
            else if(nums[m] >= target)
            {
                r = m-1;
            }
        }
        
        l = 0;
        r = (nums.length-1);
        
        // BINARY SEARCH TO FIND THE LAST OCCURRING INDEX.
        while(l <= r)
        {
            int m = l+((r-l)/2);
            
            if(nums[m] == target && (m == (nums.length-1) || nums[m+1] != target))
            {
                ans[1] = m;
                break;
            }
            else if(nums[m] <= target)
            {
                l = m+1;
            }
            else if(nums[m] > target)
            {
                r = m-1;
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(LOG N)
// SPACE COMPLEXITY : O(1)
