# PROBLEM DESCRIPTION : https://leetcode.com/problems/sequential-digits/

# MY APPROACH IS TO USE STRING SLICING TO FIND ALL THE COMBINATIONS OF DIGITS THAT SATISFY THE GIVEN CONDITION AND IS OF LENGTH
# OF THE NUMBER OF DIGITS FROM LOW TO HIGH. THEN CHECK IF THE INTEGERS ARE IN BETWEEN LOW AND HIGH, IF IT IS THEN APPEND IT INTO
# THE ANS ARRAY.

class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        ans = []
        s = "123456789"
        l = len(str(low))
        r = len(str(high))
        
        # TRAVERSING ALL THE COMBINATIONS OF LENGTH OF THE NUMBER OF DIGITS FROM LOW TO HIGH.
        while(l <= r):
            
            for i in range(0,(10-l)):
                d = int(s[i:i+l])
                
                if(d >= low and d <= high):
                    ans.append(d)
                    
            l += 1
        
        return ans
 
# TIME COMPLEXITY : O(1) 
# SPACE COMPLEXITY : O(1) 
