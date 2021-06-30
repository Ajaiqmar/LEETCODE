class Solution:
    def check(self, nums: List[int]) -> bool:
        dipCount = 0
        
        for i in range(1,len(nums)):
            if(nums[i]<nums[i-1]):
                dipCount += 1
        
        if(nums[0]<nums[-1]):
            dipCount += 1
        
        if(dipCount <= 1):
            return True
        
        return False
