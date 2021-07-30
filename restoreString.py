# THE PROBLEM STATEMENT IS TO FIND THE SHUFFLED STRING, WHEN ORIGINAL STRING AND AN ARRAY OF INDICES WHICH CONTAINS WHERE THE CHARACTERS NEED TO BE IS GIVEN.

# MY APPROACH IS TO CREATE A DICTIONARY WHICH STORES THE CHARCTER VALUE OF THE GIVEN STRING WITH ITS CORRESPONDING
# INDEX VALUE AS THE KEY, AND THEN TRAVERSE THE ARRAY ONCE AGAIN TO PLOT THE SHUFFLED STRING.

class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        letterPos = {}
        shuffledString = ""
        
        # CREATING THE DICTIONARY USING THE INDEX AS THE KEY AND THE CHARACTER AS THE VALUE.
        for i in range(len(s)):
            letterPos[indices[i]] = s[i]
        
        # PLOTTING THE SHUFFLED STRING USING THE DICTIONARY.
        for i in range(len(s)):
            shuffledString += letterPos[i]
            
        return shuffledString

# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(N)
