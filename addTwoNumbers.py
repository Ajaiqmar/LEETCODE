# THE PROBLEM STATEMENT IS TO ADD THE TWO INTEGERS AND RETURN THE SUM, BUT EACH DIGIT OF THE INTEGER ARE REPRESENTED IN THE FORM OF A LINKED LIST IN REVERSE ORDER.
# MY APPROACH IS TO TRAVERSE THE LINKED LIST AND AT EACH NODE ADD THE DIGITS ALONG WITH CARRY OVER VALUE, AND STORE THE VALUE ONTO A NEW NODE.

# FOLLOW UP : WE COULD ALSO ACHIEVE THIS WITHOUT ANY EXTRA SPACE, BY MAKING USE OF THE NODES FROM THE GIVEN LINKED LIAST AND FORMING A NEW LINKED LIST.

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carryOver = 0
        newListHead = None
        newListTail = None
        # NEWLISTHEAD HOLDS THE HEAD OF THE NEW LINKED LIST.
        
        #TRAVERSING THE NODES OF L1 AND L2
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
        
        # CHECKING FOR ANY RESIDUAL NODES IN L1
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
        
        # CHECKING FOR ANY RESIDUAL NODES IN L2
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
        
        # CHECKING FOR ANY RESIDUAL CARRY OVER VALUE
        if(carryOver != 0):
            temp = ListNode(carryOver)
            
            if(newListHead == None):
                newListHead = temp
                newListTail = temp
            else:
                newListTail.next = temp
                newListTail = newListTail.next
        
        return newListHead
   
# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(N)
