class Solution(object):
    def arraySign(self, nums):
        product = 1
        
        for i in nums:
            product *= i
        
        if(product == 0):
            return 0
        elif(product > 0):
            return 1
        else:
            return -1
