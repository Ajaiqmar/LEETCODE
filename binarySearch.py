class Solution:
    def binarySearch(self,arr,start,end,target):
        if(start <= end):
            mid = start+((end-start)//2)
            
            if(arr[mid] == target):
                return mid
            
            elif(arr[mid] < target):
                return self.binarySearch(arr,mid+1,end,target)
            
            elif(arr[mid] > target):
                return self.binarySearch(arr,start,mid-1,target)
                
        return -1 
            
    def search(self, nums: List[int], target: int) -> int:
        return self.binarySearch(nums,0,len(nums)-1,target)
