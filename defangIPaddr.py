# THE PROBLEM STATEMENT IS TO RETURN DEFANGED IP ADDRESS OF THE GIVEN VALID IP ADDRESS

# I.E. VALID IP ADDRESS IS "127.0.0.1" -> DEFANGED IP ADDRESS IS "127[.]0[.]0[.]1"

# MY APPROACH IS TO TRAVERSE THE STRING AND WHEN A DOT CHARACTER IS ENCOUNTERED APPEND "[.]" TO THE NEW STRING ELSE APPEND THE 
# TRAVERSED CHARACTER.

class Solution:
    def defangIPaddr(self, address: str) -> str:
        defangedIPAddress = ""
        
        # TRAVERSING THE STRING TO CREATE THE DEFANGED IP ADDRESS
        for i in address:
            if(i == '.'):
                defangedIPAddress += "[.]"
            else:
                defangedIPAddress += i
        
        return defangedIPAddress

# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(N)
