# THE PROBLEM STATEMENT IS TO MOVE ALL THE ZEROS TO THE RIGHT MOST END WITHOUT AFFECTING THE FLOW OF OTHER INTEGERS.
# THE FOLLOW UP QUESTION IS TO CARRY OUT THIS FUNCTION IN O(1) SPACE COMPLEXITY AND TO MINIMIZE THE NUMBER OF OPERATIONS DONE.

# MY APPROACH IS TO USE A SEPERATE INDEX COUNTER THEN TRAVERSE THE ARRAY, AS WE ARE TRAVERSING WHENEVER WE ENCOUNTER A NON-ZERO DIGIT WE SWAP IT WITH THE 
# SLIDING INDEX AND INCREMENT IT, WHICH CAN YIELD THE REQUIRED ARRAY.

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        index = 0
        
        # TRAVERSING THE GIVEN ARRAY.
        for i in range(len(nums)):
            if(nums[i] != 0):
                temp = nums[index]
                nums[index] = nums[i]
                nums[i] = temp
                index += 1
                
# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(1)
