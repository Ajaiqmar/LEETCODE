# THE PROBLEM STATEMENT IS TO CONVERT THE GIVEN STRING INTO A FANCY STRING.
# A STRING IS CALLED A FANCY STRING WHEN THERE IS NO THERE CONSECUTIVE SAME CHARACTERS.

# MY APPROACH IS TO TRAVERSE THE STRING FROM 0 TO LEN(S)-2 THEN CHECK IF CURRENT CHARACTER IS EQUAL TO THE NEXT TWO CHARACTERS, IF IT IS THEN WE DO
# NOT APPEND IT TO THE RESULTANT STRING ELSE WE APPEND IT TO THE RESULTANT STRING.

class Solution:
    def makeFancyString(self, s: str) -> str:
        fancyString = ""
        
        # TRAVERSE THE GIVEN STRING
        for i in range(len(s)-2):
            if(s[i] == s[i+1] and s[i] == s[i+2]):
                continue
            else:
                fancyString += s[i]
        
        fancyString += s[len(s)-2:]
        
        return fancyString
      
# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(N) SINCE STRING IS CONSIDERED AS AN ARRAY OF CHARACTERS.
