class Solution {
    public int dominantIndex(int[] nums) {
        int maxValue = -1,numsIndex = -1;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] > maxValue)
            {
                maxValue = nums[i];
                numsIndex = i;
            }
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(i != numsIndex)
            {
                if(nums[i]!=0 && (maxValue/nums[i])<2)
                {
                    return -1;
                }
            }
        }
        
        return numsIndex;
    }
}
