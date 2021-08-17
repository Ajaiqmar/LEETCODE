# THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF STRINGS IN PATTERNS ARRAY THAT IS A SUBSTRING OF WORD STRING.

# MY APPROACH IS TO USE THE BUILT-IN IN FUNCTION TO CHECK IF THE STRING IN THE PATTERNS ARRAY IS A SUBSTRING OF WORD STRING, AND INCREMENT THE ANS VALUE BY ONE.
class Solution:
    def numOfStrings(self, patterns: List[str], word: str) -> int:
        ans = 0
        
        # TRAVERSING THE PATTERNS ARRAY.
        for i in patterns:
            if i in word:
                ans += 1
        
        return ans
 
# TIME COMPLEXITY : O(N*M)
# SPACE COMPLEXITY : O(1)
