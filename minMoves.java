class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0],sum = nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            sum += nums[i];
            if(nums[i] < min)
            {
                min = nums[i];
            }
        }
        
        return sum-((nums.length)*min);
    }
}
