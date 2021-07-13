class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carryOver = 0
        newListHead = None
        newListTail = None
        
        while(l1 != None and l2 != None):
            val = l1.val+l2.val+carryOver
            carryOver = val//10
            val = val%10
            
            temp = ListNode(val)
            
            if(newListHead == None):
                newListHead = temp
                newListTail = temp
            else:
                newListTail.next = temp
                newListTail = newListTail.next
            
            l1 = l1.next
            l2 = l2.next
        
        while(l1 != None):
            val = l1.val+carryOver
            carryOver = val//10
            val = val%10
            
            temp = ListNode(val)
            
            
            if(newListHead == None):
                newListHead = temp
                newListTail = temp
            else:
                newListTail.next = temp
                newListTail = newListTail.next
            
            l1 = l1.next
        
        while(l2 != None):
            val = l2.val+carryOver
            carryOver = val//10
            val = val%10
            
            temp = ListNode(val)
            
            
            if(newListHead == None):
                newListHead = temp
                newListTail = temp
            else:
                newListTail.next = temp
                newListTail = newListTail.next
            
            l2 = l2.next
        
        if(carryOver != 0):
            temp = ListNode(carryOver)
            
            if(newListHead == None):
                newListHead = temp
                newListTail = temp
            else:
                newListTail.next = temp
                newListTail = newListTail.next
        
        return newListHead
