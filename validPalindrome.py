# THE PROBLEM STATEMENT IS TO CHECK IF THE STRING WILL BE A PALINDROME AFTER REMOVING ATMOST ONE CHARACTER.

# MY APPROACH IS TO TRAVERSE THE STRING USING TWO POINTER APPROACH RECURSIVELY, IF THE CURRENT CHARACTERS MATCH WE INCREMENT BOTH POINTERS BY ONE ELSE IF
# THE CURRENT CHARACTERS DO NOT MATCH WE WILL INCREMENT/DECREMENT THE COUNT BY ONE AND CHECK IF THE COUNT IS GREATER THAN ONE BECAUSE WE ARE ALLOWED TO REMOVE ONLY 
# ONE CHARACTER FROM THE STRING, ELSE WE WILL CHECK WHETHER THE LEFT POINTERS CURRENT VALUE IS EQUAL TO THE NEXT VALUE OF RIGHT POINTER OR VICE VERSA AND 
# CONTINUE THE RECURSIVE CALLS IF IT DOES BY INCREMENTING/DECREMENTING THE RESPECTIVE POINTERS. FINALLY WHEN ALL THE CHARACTERS MATCH AFTER REMOVING
# ATMOST ONE CHARACTER FROM THE STRING, RETURN TRUE, ELSE FALSE.

class Solution:
    # RECURSIVE FUNCTION FOR CHECKING WHETHER THE GIVEN STRING IS PALINDROME AFTER REMOVING ATMOST ONE CHARCTER.
    def validate(self,s,i,j,count):
        if(i<j):
            if(s[i] == s[j]):
                return self.validate(s,i+1,j-1,count)
            
            else:
                count += 1
                
                if(count > 1):
                    return False
                
                if(s[i] == s[j-1] and s[i+1] == s[j]):
                    return self.validate(s,i,j-1,count) or self.validate(s,i+1,j,count)
                
                elif(s[i] == s[j-1]):
                    return self.validate(s,i,j-1,count)
                
                elif(s[i+1] == s[j]):
                    return self.validate(s,i+1,j,count)
                
                else:
                    return self.validate(s,i,j,count)
                
        return True
    
    def validPalindrome(self, s: str) -> bool:
        return self.validate(s,0,len(s)-1,0)

# TIME COMPLEXITY : O(N) WHERE N IS THE LENGTH OF THE GIVEN STRING
# SPACE COMPLEXITY : O(N) WHERE N IS THE LENGTH OF THE GIVEN STRING
