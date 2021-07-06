class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        maxFrequency = -inf
        minLength = inf
        frequency = {}
        
        for i in range(len(nums)):
            if nums[i] not in frequency:
                frequency[nums[i]] = [1,i,i]
            else:
                frequency[nums[i]][0] += 1
                frequency[nums[i]][2] = i
            
            if(frequency[nums[i]][0] > maxFrequency):
                maxFrequency = frequency[nums[i]][0]
                minLength = frequency[nums[i]][2]-frequency[nums[i]][1]+1
            elif(frequency[nums[i]][0] == maxFrequency and minLength > (frequency[nums[i]][2]-frequency[nums[i]][1]+1)):
                minLength = frequency[nums[i]][2]-frequency[nums[i]][1]+1

        
        return minLength
