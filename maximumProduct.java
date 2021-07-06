class Solution {
    public int maximumProduct(int[] nums) {
        int largest = Integer.MIN_VALUE,secondLargest = Integer.MIN_VALUE,thirdLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE,secondSmallest = Integer.MAX_VALUE,thirdSmallest = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] > largest)
            {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = nums[i];
            }
            else if(nums[i] > secondLargest)
            {
                thirdLargest = secondLargest;
                secondLargest = nums[i];
            }
            else if(nums[i] > thirdLargest)
            {
                thirdLargest = nums[i];
            }
            
            if(nums[i] < smallest)
            {
                thirdSmallest = secondSmallest;
                secondSmallest = smallest;
                smallest = nums[i];
            }
            else if(nums[i] < secondSmallest)
            {
                thirdSmallest = secondSmallest;
                secondSmallest = nums[i];
            }
            else if(nums[i] < thirdSmallest)
            {
                thirdSmallest = nums[i];
            }
        }
        
        return Math.max(largest*secondLargest*thirdLargest,largest*smallest*secondSmallest);
    }
}
