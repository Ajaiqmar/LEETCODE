class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftPrefixArray = new int[nums.length];
        int[] rightPrefixArray = new int[nums.length];
        
        for(int i=1;i<nums.length;i++)
        {
            leftPrefixArray[i] = leftPrefixArray[i-1]+nums[i-1];
        }
        
        for(int i=nums.length-2;i>=0;i--)
        {
            rightPrefixArray[i] = rightPrefixArray[i+1]+nums[i+1];
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(leftPrefixArray[i] == rightPrefixArray[i])
            {
                return i;
            }
        }
        
        return -1;
    }
}
