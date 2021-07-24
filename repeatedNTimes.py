class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        d = {}
        
        for i in nums:
            if i not in d:
                d[i] = 1
            else:
                return i
