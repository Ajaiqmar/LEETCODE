# THE PROBLEM STATEMENT IS TO CHECK IF THE GIVEN ARRAY CONTAINS N AND 2*N IN IT AND THEIR POSITIONS ARE DIFFERENT.

# MY APPROACH IS TO USE A HASHMAP TO STORE THE VALUES IN THE ARRAY AND ALSO CHECK IF I%2 OR I//2 IS PRESENT IN THE HASHMAP, IF IT IS THEN RETURN TRUE, ELSE FALSE.

class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        # INITIALISNG THE HASHMAP
        hashMap = {}
        
        # TRAVERSING THE GIVEN ARRAY.
        for i in arr:
            if((i%2 == 0 and (i//2) in hashMap) or (i*2) in hashMap):
                return True
            else:
                hashMap[i] = 1
        
        return False
      
# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(N)
