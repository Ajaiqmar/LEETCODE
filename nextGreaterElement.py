class Node:
    def __init__(self,x):
        self.val = x
        self.next = None

class Stack:
    def __init__(self):
        self.head = None
    def push(self,x):
        if(self.head == None):
            self.head = Node(x)
        else:
            temp = Node(x)
            temp.next = self.head
            self.head = temp
    def peek(self):
        if(self.head == None):
            return -1
        else:
            return self.head.val
    def pop(self):
        self.head = self.head.next

class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        d = {}
        ma = 0
        ind = -1
        stack = Stack()
        
        for i in range(len(nums2)-1,-1,-1):
            
            while(nums2[i] > stack.peek() and stack.peek() != -1):
                stack.pop()
            
            d[nums2[i]] = stack.peek()
            
            stack.push(nums2[i])
        
        return [d[i] for i in nums1]
