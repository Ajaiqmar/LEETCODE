// THE PROBLEM STATEMENT IS TO RETURN A MODIFIED LINKED LIST WHERE ALL THE ODD-INDEXED NODES WILL BE ARRANGED IN THE FRONT FOLLOWED BY THE EVEN-INDEXED NODES FROM 
// THE GIVEN LINKED LIST.

// FOLLOW UP QUESTION WAS TO DO IT IN O(1) SPACE AND O(N) TIME COMPLEXITY

// MY APPROACH IS TO USE FOUR POINTERS NAMELY ODDHEAD, EVENHEAD, ODDTAIL AND EVENTAIL. THERE WILL ALSO BE A COUNTER TO CHECK IF IT IS ODD OR EVEN INDEXED NODE.
// THEN FORM TWO NEW LINKED LIST WITH THE PRE-FORMED NODES BY TRAVERSING THE GIVEN LINKED LIST AND MERGE THEM AT THE END.

class Solution 
{
    public ListNode oddEvenList(ListNode head) 
    {
        if(head == null)
        {
            return null;
        }
        
        ListNode oddHead = null,oddTail = null;
        ListNode evenHead = null,evenTail = null;
        ListNode temp = head;
        int count = 1;
        
        // TRAVERSING THE GIVEN LINKED LIST.
        while(temp != null)
        {
            ListNode ptr = temp;
            temp = temp.next;
            ptr.next = null;
            
            if(count%2 == 1)
            {
                if(oddHead == null)
                {
                    oddHead = ptr;
                    oddTail = ptr;
                }
                else
                {
                    oddTail.next = ptr;
                    oddTail = ptr;
                }
            }
            else
            {
                if(evenHead == null)
                {
                    evenHead = ptr;
                    evenTail = ptr;
                }
                else
                {
                    evenTail.next = ptr;
                    evenTail = ptr;
                }
            }
            
            count += 1;
        }
        
        oddTail.next = evenHead;
        
        return oddHead;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
