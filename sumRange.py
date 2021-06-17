class NumArray:

    def __init__(self, nums: List[int]):
        self.arr = nums
        
        for i in range(1,len(nums)):
            self.arr[i] += self.arr[i-1]

    def sumRange(self, left: int, right: int) -> int:
        r = self.arr[right]
        l = 0
        if((left-1)>=0):
            l = self.arr[left-1]
        
        return r-l
