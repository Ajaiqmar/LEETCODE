// THE PROBLEM STATEMENT IS TO FIND THE PEAK ELEMENT'S INDEX IN THE GIVEN ARRAY NUMS IN O(LOG N) TIME COMPLEXITY. AN ELEMENT IS SAID TO BE
// A PEAK ELEMENT IF BOTH ADJACENT ELEMENTS ARE LOWER THAN THAT ELEMENT.

// MY APPROACH IS TO USE DIVIDE AND CONQUER TECHNIQUE, WE SPLIT THE ARRAY USING THE MID-POINT, THEN CHECK IF THE ELEMENT AT THE MID-POINT IS A PEAK ELEMENT,
// THEN WE CONSIDER THE LEFT SUBARRAY IN THE NEXT FUNCTION CALL AND THEN THE RIGHT SUBARRAY IN THE NEXT FUNCTION CALL.

class Solution 
{
    // FUNCTION TO CARRY OUT THE DIVIDE AND CONQUER TECHNIQUE.
    public static void binarySearch(int[] nums,int left,int right,int[] ans)
    {
        if(left <= right)
        {
            int mid = left + ((right-left)/2);
            
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1]))
            {
                ans[0] = ((ans[0] == -1)?mid:ans[0]); 
            }
            
            binarySearch(nums,left,mid-1,ans);
            binarySearch(nums,mid+1,right,ans);
        }
    }
    public int findPeakElement(int[] nums) 
    {
        int[] ans = new int[1];
        ans[0] = -1;
        
        binarySearch(nums,0,nums.length-1,ans);
        
        return ans[0];
    }
}

// TIME COMPLEXITY : O(LOG N)
// SPACE COMPLEXITY : O(1)
