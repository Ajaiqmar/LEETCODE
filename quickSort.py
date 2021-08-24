# THE PROBLEM STATEMENT IS TO SORT THE ARRAY USING QUICK SORT ALGORITHM.

# QUICK SORT IS ONE OF THE FASTEST SORTING ALGORITHM. IF FOLLOWS THE DIVIDE AND CONQUER CONCEPT. 

# SO THE BASIC APPROACH IS ON EACH RECURSIVE CALL WE CHECK WHETHER THE GIVEN SUBARRAY HAS ELEMENTS IN THE FUNCTION CALL, THEN WE MOVE ONTO PARTITIONING IT,
# IN THE PARTITION FUNCTION WE TAKE ANY ELEMENT IN THE ARRAY AS A PIVOT ELEMENT THEN ARRANGE THE ARRAY IN SUCH A WAY THAT ALL THE LEFT ELEMENTS TO THE PIVOT
# ELEMENT ARE LESS THAN THE PIVOT AND ALL RIGHT ELEMENTS ARE GREATER THAN THE PIVOT, THEN RETURN THE PIVOT INDEX. NOW WE MAKE A FUNCTION CALL
# TO QUICKSORT FUNCTION TAKING LEFT SUBARRAY TO THE PIVOT AND RIGHT SUBARRAY TO THE PIVOT.

class quickSort:
    def __init__(self, arr):
        self.arr = arr
        self.quickS(0, len(arr) - 1)

    # PARTITION FUNCTION
    def partition(self, low, high):
        pivot = self.arr[high]
        ind = low

        for i in range(low, high+1):
            if (self.arr[i] <= pivot):
                temp = self.arr[i]
                self.arr[i] = self.arr[ind]
                self.arr[ind] = temp
                ind += 1

        return ind - 1

    # QUICKSORT FUNCTION
    def quickS(self, low, high):
        if (low < high):
            p = self.partition(low, high)
            self.quickS(low, p - 1)
            self.quickS(p + 1, high)


q = quickSort([5,3,4,1,2,10,8,7,9,6])
print(q.arr)

# TIME COMPLEXITY : O(N*LOG N)
# SPACE COMPLEXITY : O(1)
