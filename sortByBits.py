# THE PROBLEM STATEMENT IS TO SORT THE GIVEN ARRAY USING THE NUMBER OF SET BITS IN ASCENDING ORDER. IF TWO INTEGERS HAVE SAME NUMBER OF SET BITS, THEN YOU SHOULD 
# CONSIDER THE VALUE OF THE INTEGER IN ASCENDING ORDER.

# MY APPROACH IS TO FIRST FIND THE NUMBER OF SET BITS OF EACH INTEGER THEN STORE THEM ALONG WITH THE INTEGERS IN A 2D ARRAY FORMAT.
# THEN WE SORT THEM USING THE QUICK SORT METHOD. IN QUICK SORT METHOD, WE FIRST CONSIDER A PIVOT ELEMENT THEN ARRANGE THE ARRAY IN SUCH A WAY THAT
# ALL THE INTEGERS IN THE LEFT ARE LESSER THAN THE PIVOT AND ALL THE INTEGERS IN THE RIGHT ARE GREATER THAN THE PIVOT ELEMENT.

class Solution:
    # FUNCTION TO FIND THE NUMBER OF SET BITS.
    def countOfBits(self,n):
        count = 0
        
        while(n != 0):
            if(n%2 == 1):
                count += 1
            n = n//2
        
        return count
    
    # FUNCTION TO PARTITION THE GIVEN ARRAY USING THE PIVOT ELEMENT.
    def partition(self,low,high):
        pivot = self.a[high]
        ind = low
        
        for i in range(low,high+1):
            if(self.a[i][1] < pivot[1]):
                temp = self.a[ind]
                self.a[ind] = self.a[i]
                self.a[i] = temp
                ind += 1
            elif(self.a[i][1] == pivot[1] and self.a[i][0] <= pivot[0]):
                temp = self.a[ind]
                self.a[ind] = self.a[i]
                self.a[i] = temp
                ind += 1
        
        return ind-1
    
    # QUICK SORT FUNCTION.
    def quickSort(self,low,high):
        if(low < high):
            p = self.partition(low,high)
            
            self.quickSort(low,p-1)
            self.quickSort(p+1,high)
   
    def sortByBits(self, arr: List[int]) -> List[int]:
        self.a = []
        
        for i in range(len(arr)):
            self.a.append([arr[i],self.countOfBits(arr[i])])
        
        self.quickSort(0,len(arr)-1)
        
        for i in range(len(arr)):
            arr[i] = self.a[i][0]
        
        return arr
      
# TIME COMPLEXITY : O((N*LOG N)+(N*LOG N)+(N))
# SPACE COMPLEXITY : O(N*2)
        
        
