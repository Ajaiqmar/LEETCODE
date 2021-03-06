# THE PROBLEM STATEMENT IS RETURN THE MINMUM DIFFERENCE BETWEEN THE HIGHEST AND LOWEST INTEGER OF ALL THE SUB-SEQUENCE OF LENGTH K.

# MY APPROACH IS, SINCE IT IS A SUB-SEQUENCE, WE ARE ENTITLED TO CONSIDER ANY COMBINATION OF LENGTH K. BUT THAT WOULD LEAD US TO CONSIDER
# ALL THE POSSIBLE COMBINATIONS OF LENGTH K. SO IT WOULDN'T BE IDLE. SO THEN WE ARE GOING TO BE CONSIDERING ABOUT THE PROCESS OF OBTAINING THE MINIMUM DIFFERENCE.
# FOR THAT, WE JUST REQUIRE A SORTED ARRAY, AND THEN WE JUST HAVE TO CONSIDER THE I-TH ELEMENT AND THE (I+K)-TH ELEMENT IN THAT SORTED ARRAY TO OBTAIN THE 
# MINIMUM DIFFERENCE.

class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        if(k == 1):
            return 0
        
        # SORTING THE ARRAY.
        nums.sort()
        ans = nums[-1]
        
        # TRAVERSING THE ARRAY TO FIND THE MINIMUM DIFFERENCE AMONG ALL THE SUBSEQUENCE.
        for i in range(len(nums)-(k-1)):
            if((nums[i+k-1]-nums[i]) < ans):
                ans = nums[i+k-1]-nums[i]
        
        return ans
      
# TIME COMPLEXITY : O(N*LOG N)
# SPACE COMPLEXITY : O(1)
