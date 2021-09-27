# THE PROBLEM STATEMENT IS TO RETURN TRUE IF ALL THE CHARACTERS IN THE STRING ARE EITHER LOWERCASE OR UPPERCASE OR IF THE FIRST
# LETTER OF THE STRING IS UPPERCASE AND THE REST ARE LOWERCASE, ELSE WE HAVE TO RETURN FALSE.

# MY APPROACH IS TO MAKE USE OF THE ISUPPER() , ISLOWER() AND SLICING OPERATION TO VERIFY THE ABOVE CONDITIONS.

class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        # VERIFYING THE GIVEN CONDITIONS.
        if(word.isupper() or word.islower() or (word[0].isupper() and word[1:].islower())):
            return True
        else:
            return False
        
# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(1)
