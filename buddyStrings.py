# THE PROBLEM STATEMENT IS TO CHECK WHETHER THE GIVEN STRINGS IS BUDDY STRING. A STRING IS CALLED A BUDDY STRING IF BOTH THE STRINGS
# BECOMES EQUAL AFTER EXACTLY SWAPPING TWO CHARACTERS IN ANY ONE OF THE STRING.

# MY APPROACH IS TO DIVIDE THE PROBLEM INTO SUB PROBLEMS AND THEN WORKING THEM OUT INDIVIDUALLY.
# 1. CHECK WHETHER THEY ARE OF EQUAL LENGTH. IF NOT RETURN FALSE

# 2. NEXT CHECK WHETHER BOTH THE STRINGS CONTAIN EQUAL NUMBER OF ELEMENTS.

# 3. NEXT, CHECK IF THEY ARE BOTH ALREADY EQUAL AND IF THEY ARE, CHECK WHETHER THERE ARE REPEATED CHARACTERS IN THE STRING, IF BOTH THE CONDITION
#    IS TRUE RETURN TRUE.

# 4. NEXT CHECK IF THERE ARE EXACTLY TWO MKISPLACED CHRACTERS, IF IT IS RETURN TRUE ELSE FALSE.

class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        # CHECKING IF THEY ARE EQUAL IN LENGTH
        if(len(s) != len(goal) or len(s) == 1):
            return False
        
        alphad = {}
        # FLAG VARIABLE IS TO CHECK WHETHER THE GIVEN STRINGS CONTAINS REPEATED CHARACTERS.
        flag = 0
        
        # CHECKING BOTH THE STRINGS CONTAIN EQUAL NUMBER OF ELEMENTS USING A DICTIONARY
        for i in s:
            if i in alphad:
                alphad[i] += 1
                flag = 1
            else:
                alphad[i] = 1
        
        # IF BOTH THE STRINGS ARE EQUAL AND THEY CONTAIN REPEATED CHARACTERS.
        if(s == goal and flag == 1):
            return True
        
        for i in goal:
            if i not in alphad or alphad[i] == 0:
                return False
            else:
                alphad[i] -= 1
        
        countOfMisplaced = 0
        
        # CHECKING FOR THE NUMBER OF MISPLACED CHARCTERS.
        for i in range(len(s)):
            if(s[i] != goal[i]):
                countOfMisplaced += 1
        
        return countOfMisplaced == 2

# TIME COMPLEXITY : O(MAX(N,M)) WHERE N IS THE LENGTH OF STRING 1 AND M IS THE LENGTH OF STRING2.
# SPACE COMPLEXITY : O(N)
