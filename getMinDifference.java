class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDifference = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == target)
            {
                if(Math.abs(i-start) < minDifference)
                {
                    minDifference = Math.abs(i-start);
                }
            }
        }
        
        return minDifference;
    }
}
