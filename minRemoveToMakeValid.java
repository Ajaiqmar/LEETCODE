// PROBLEM DESCRIPTION : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

// MY APPROACH IS TO USE THE STACK DATA STRUCTURE TO REMOVE THE UNMATCHED PARANTHESES. FIRSTLY, TRAVERSE THE GIVEN STRING WHILE TRAVERSING IF THE CHARACTER AT
// A PARTICULAR INDEX IS '(' WE WILL INSERT IT INTO THE STACK ALONG WITH ITS INDEX, ELSE IF THE CHARACTER AT A PARTICULAR INDEX IS ')' WE WILL CHECK THE ELEMENT AT THE TOP 
// OF THE STACK, IF IT IS '(' THEN WE WILL POP THE ELEMENT FROM THE STACK, ELSE IF IT IS ')' THEN WE INSERT IN INTO THE STACK, ELSE IF THE STACK IS EMPTY TEHN WE INSERT 
// INTO THE STACK. FINALLY WE EMPTY THE ARRAY AND MARK ALL THE ELEMENTS INSIDE THE ARRAY, THEN WE COMBINE THE REMAINING CHARACTERS. VOILA!! WE GET OUR ANSWER.

// NODE STRUCTURE OF THE STACK.
class Node:
    def __init__(self,val,ind):
        self.val = val
        self.ind = ind
        self.next = None
        

class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        head = None
        s = list(s)
          
        // TRAVERSING THE GIVEN STRING.
        for i in range(len(s)):
            if(s[i] == '('):
                
                if(head == None):
                    head = Node('(',i)
                    
                else:
                    temp = Node('(',i)
                    temp.next = head
                    head = temp
                
            elif(s[i] == ')'):
                
                if(head == None):
                    head = Node(')',i)
                    
                elif(head.val == '('):
                    head = head.next
                    
                elif(head.val == ')'):
                    temp = Node(')',i)
                    temp.next = head
                    head = temp
            
        
        // EMPTYING THE STACK
        while(head != None):
            s[head.ind] = '-'
            head = head.next
        
        ans = ""
        
        for i in s:
            if(i != '-'):
                ans += i
        
        return ans
        
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
