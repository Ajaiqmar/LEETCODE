# PROBLEM DESCRIPTION : https://leetcode.com/problems/kth-largest-element-in-an-array/

# MY APPROACH IS TO BUILD A PRIORITY QUEUE OF FIXED SIZE K USING BINARY HEAP DATA STRUCTURE, WHICH WILL CONTAIN ALL THE VALUES ARRANGED FROM LOWER TO HIGHER IN VALUE IN THE
# TREE. WE WILL BE CREATING A CUSTOM PRIORITY QUEUE CLASS FROM SCRATCH TO FIT OUR NEEDS. THEN WE WILL TRAVERSE THE GIVEN ARRAY AND INSERT THE VALUES INTO IT.
# FINALLY, THE VALUE AT THE TOP OF THE PRIORITY QUEUE IS THE K TH LARGEST VALUE IN THE GIVEN ARRAY.

# CREATE A CUSTOM PRIORITY QUEUE CLASS. 
class priorityQueue:
  
    # CONSTRUCTOR
    def __init__(self,k):
        
        self.maxNoOfNodes = k
        self.noOfNodes = 0
        self.queue = []
        
    # FUNCTION TO INSERT AN ELEMENT.
    def enqueue(self,val):
        
        if(self.noOfNodes < self.maxNoOfNodes):
            self.queue.append(val)
            self.noOfNodes += 1
            self.heapifyUp()
            
        elif(self.queue[0] < val):
            self.dequeue()
            self.queue[-1] = val
            self.noOfNodes += 1
            self.heapifyUp()
    
    # FUNCTION TO DELETE AN ELEMENT.
    def dequeue(self):
        
        self.queue[0] = self.queue[-1]
        self.noOfNodes -= 1
        self.heapifyDown();
    
    # HEAPIFY UP FUNCTION
    def heapifyUp(self):
        
        ind = self.noOfNodes-1
        
        while(ind > 0):
            
            pInd = (ind-1)//2
            
            if(self.queue[pInd] > self.queue[ind]):
                
                temp = self.queue[pInd]
                self.queue[pInd] = self.queue[ind]
                self.queue[ind] = temp
                
                ind = pInd
                
            else:
                
                break
    
    # HEAPIFY DOWN FUNCTION.
    def heapifyDown(self):
        
        ind = 0
        
        while(((ind*2)+1) < self.noOfNodes):
            
            lInd = (ind*2)+1
            rInd = (ind*2)+2
            
            if(self.queue[lInd] < self.queue[rInd]):
                
                if(self.queue[ind] > self.queue[lInd]):
                    
                    temp = self.queue[lInd]
                    self.queue[lInd] = self.queue[ind]
                    self.queue[ind] = temp
                    
                    ind = lInd
                else:
                    break
                    
            else:
                
                if(self.queue[ind] > self.queue[rInd]):
                    
                    temp = self.queue[rInd]
                    self.queue[rInd] = self.queue[ind]
                    self.queue[ind] = temp
                    
                    ind = rInd
                else:
                    break
                    
    # FUNCTION TO RETURN THE TOP ELEMENT OF THE BINARY HEAP.
    def peek(self):
        
        return self.queue[0]
    
    

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        queue = priorityQueue(k)
        
        # TRAVERSING THE GIVEN ARRAY.
        for i in range(len(nums)):
            queue.enqueue(nums[i])
        
        return queue.peek()
 
# TIME COMPLEXITY : O(N LOG K)
# SPACE COMPLEXITY : O(K)
        
        
        
        
