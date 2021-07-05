class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = []
        d = {}
        totalSum = (n*(n+1))//2
        givenSum = 0
        
        for i in range(n):
            givenSum += nums[i]
            if nums[i] not in d:
                d[nums[i]] = 1
            else:
                d[nums[i]] += 2
                ans.append(nums[i])
        
        ans.append(ans[0]+(totalSum-givenSum))
        return ans
