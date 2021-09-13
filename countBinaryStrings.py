# THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF SUBSTRING FROM THE BINARY STRING CONTAINS EQUAL NUMBER OF ONES AND ZEROS.

# MY APPROACH IS TO USE THE KADANE ALGORITHM TO CHECK FOR THE COUNT OF CONTINOUS ZEROS OR ONES, THEN WE ADD THE MINIMUM VALUE BETWEEN THE CURRENT CONTINOUSB COUNT
# AND THE RPEVIOUS CONTINOUS COUNT TO THE ANSWER VARIABLE.
# I.E. "00110011" -> [2,2,2,2] IS THE ARRAY OF CONTINOUS COUNT OF ZEROS AND ONES, WE CONSIDER ALL THE ADJACENT PAIRS AND ADD THE MINIMUM VALUE BETWEEN
# TEM TO THE ANSWER 2+2+2 = 6.

class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        prev = 0
        curr = 1
        ans = 0
        
        # TRAVERSING THE STRING S
        for i in range(1,len(s)):
            if(s[i] == s[i-1]):
                curr += 1
            else:
                ans += min(prev,curr)
                prev = curr
                curr = 1
        
        ans += min(prev,curr)
        
        return ans

# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(1)
