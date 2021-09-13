# THE PROBLEM STATEMENT IS TO RETURN AN ARRAY WHICH CONTAINS THE NUMBER OF SET BITS OF ALL THE INTEGERS FROM 1 TO N.

# MY APPROACH IS TO USE THE BIN FUNCTION AND THE COUNT OF FUNCTION IN PYTHON TO FIND THE NUMBER OF SET BITS IN PYTHON.

class Solution:
    def countBits(self, n: int) -> List[int]:
        return [((bin(i)[2:]).count('1')) for i in range(n+1)]
    
# TIME COMPLEXITY : O(N LOG N)
# SPACE COMPLEXITY : O(N)
