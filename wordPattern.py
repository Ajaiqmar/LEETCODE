# THE PROBLEM STATEMENT IS TO RETURN WHETHER THE CHARACTER PATTERN STRING MATCHES THE WORDS PATTERN IN THE SENTENCE S.

# MY APPROACH IS TO FIRST CHECK DIVIDE THE SENTENCE INTO A LIST OF WORDS, THEN CHECK IF THE NUMBER OF CHARCTERS IN PATTERN IS SAME AS THE NUMBER OF WORDS IN
# THE SENTENCE. IF IT IS CONTINUE, ELSE RETURN FALSE. NOW, WE HAVE TO STORE THE CHARACTER AND THE MATCHING WORD IN AN HASHMAP OR DICTIONARY.
# IF THERE EXISTS A CHARACTER WHICH MAPE TO TWO DIFFERENT WORDS OR VICE VERSA THEN RETURN FALSE, ELSE RETURN TRUE.

class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        s = s.split()
        
        if(len(pattern)!=len(s)):
            return False
        
        dp = {}
        ds = {}
        
        # TRAVERSING THE PATTERN STRING AND THE LIST OF STRINGS.
        for i in range(len(s)):
            if pattern[i] in dp and s[i] in ds and dp[pattern[i]]!=ds[s[i]]:
                return False
            elif pattern[i] in dp and s[i] not in ds:
                return False
            elif pattern[i] not in dp and s[i] in ds:
                return False
            else:
                dp[pattern[i]] = i
                ds[s[i]] = i
        
        return True

# TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF CHARACTERS IN THE PATTERN STRING.
# SPACE COMPLEXITY : O(N)
