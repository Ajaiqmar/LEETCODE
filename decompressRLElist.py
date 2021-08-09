# THE PROBLEM STATEMENT IS RETURN THE DECOMPRESSED ARRAY OF THE GIVEN ARRAY.
# A DECOMPRESSED ARRAY IS FORMED BY APPENDING I TIMES I+1 ELEMENT OF THE GIVEN ARRAY INTO THE DECOMPRESSED ARRAY.

# MY APPROACH IS TO APPLY THE BRUTE FORCE APPROACH TRAVERSE THE GIVEN LIST, THEN LOOP I TIMES AND INSERT THE I+1 ELEMENT ONTO THE DECOMPRESSED ARRAY.

class Solution:
    def decompressRLElist(self, nums: List[int]) -> List[int]:
        decompressedList = []
        
        # TRAVERSING THE GIVEN LIST BY HOPPING TWO INDEXES AT A TIME. 
        for i in range(0,len(nums),2):
            for j in range(nums[i]):
                decompressedList.append(nums[i+1])
        
        return decompressedList
  
# TIME COMPLEXITY : O(N*N)
# SPACE COMPLEXITY : O(N)
