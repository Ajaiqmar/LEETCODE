class Solution:
    def sumOfUnique(self, nums: List[int]) -> int:
        d = {}
        ans = 0
        
        for i in range(len(nums)):
            if nums[i] not in d:
                d[nums[i]] = 1
            else:
                d[nums[i]] += 1
            
        for i in d:
            if(d[i] == 1):
                ans += i
        
        return ans
