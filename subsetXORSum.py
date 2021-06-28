class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        ans = 0
        
        for i in range(1,len(nums)+1):
            for j in itertools.combinations(nums,i):
                v = 0 
                for k in j:
                    v = v^k
                ans += v
        
        return ans
