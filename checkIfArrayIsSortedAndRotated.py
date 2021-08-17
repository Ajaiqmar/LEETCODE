# THE PROBLEM STATEMENT IS TO CHECK IF THE ARRAY IS SORTED IN ASCENDING ORDER AND ROTATED.

# MY APPROACH IS TO TRAVERSE THE ARRAY AND COUNT THE NUMBER OF DIP COUNTS. A DIP IS WHEN THE PREVIOUS ELEMENT IS GREATER THAN THE CURRENT ELEMENT. IT IS ALSO NECESSARY TO COUNT 
# THE FIRST AND LAST ELEMENT. IF THE DIP COUNT IS LESS THAN OR EQUAL TO 1 (PS: THE DIP COUNT CAN ALSO BE ZERO IF ALL THE
# ELEMENTS ARE SAME.) RETURN TRUE, ELSE FALSE.

class Solution:
    def check(self, nums: List[int]) -> bool:
        dipCount = 0
        
        # TRAVBERSE THE ARRAY NUMS TO CHECK FOR DIPS.
        for i in range(1,len(nums)):
            if(nums[i]<nums[i-1]):
                dipCount += 1
        
        if(nums[0]<nums[-1]):
            dipCount += 1
        
        if(dipCount <= 1):
            return True
        
        return False

# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(1)
