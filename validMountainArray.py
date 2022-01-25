# PROBLEM DESCRIPTION : https://leetcode.com/problems/valid-mountain-array/

# MY APPROACH IS TO FIRST CHECK IF THE LENGTH OF THE ARRAY IS GREATER THAN OR EQUAL TO 3, THEN TRAVERSE THE GIVEN ARRAY, WHILE TRAVERSING CHECK IF THE CURRENT ELEMENT
# IS EQUAL TO THE PREVIOUS ELEMENT, IF IT IS THEN RETURN FALSE, ELSE IF THE CURRENT ELEMENT IS GREATER THAN THE PREVIOUS ELEMENT, IF IT IS SET THE REACHEDTOP VALUE TO 
# 0 FROM -1 THIS INDICATES THAT THERE ARE MORE THAN VALUE IN THE LEFT PART OF THE ARRAY, ELSE IF THE CURRENT ELEMENT IS LESSER THAN THE PREVIOUS ELEMENT, IF IT
# IS SET THE REACHEDTOP VALUE TO 1 FROM 0, THIS INDICATES THAT IT HAS REACHED THE MOUNTAIN TOP, ELSE RETURN FALSE. NOW FINALLY CHECK IF IT REACHEDTOP VALUE IS 1, IF IT IS 
# RETURN TRUE, ELSE RETURN FALSE.

class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        reachedTop = -1
        
        # CHECKING IF THE CURRENT LENGTH OF THE ARRAY IS GREATER THAN OR EQUAL TO 3.
        if(len(arr) < 3):
            return False
        
        # TRAVERSING THE GIVEN ARRAY.
        for i in range(1,len(arr)):
            if(arr[i] == arr[i-1]):
                return False
            
            elif(arr[i] > arr[i-1] and (reachedTop == -1 or reachedTop == 0)):
                reachedTop = 0
            
            elif(arr[i] < arr[i-1] and (reachedTop == 0 or reachedTop == 1)):
                reachedTop = 1
            
            else:
                return False
        
        
        if(reachedTop == 1):
            return True
        
        return False
      
# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(1)
