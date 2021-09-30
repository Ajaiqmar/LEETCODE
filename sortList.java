// THE PROBLEM STATEMENT IS TO SORT THE GIVEN LINKED LIST.

// FOLLOW UP QUESTION IS TO SORT THE LINKED LIST IN O(N LOG N) TIME AND O(1) SPACE.

// MY APPROACH IS TO USE MODIFIED MERGE SORT ALGORITHM TO SOLVE THE PROBLEM. HOW IT BASICALLY WORKS IS WE BREAK THE ARRAY INTO SUBARRAY UNTIL THE SUBARRAY'S LENGTH BECOMES
// 1 (ARRAY OF LENGTH ONE IS ALWAYS SORTED) THEN START MERGING THE GIVEN LINKEDLIST INTO SORTED FORMAT.

class Solution 
{
    // FUNCTION TO MERGE GIVEN TWO SORTED LINKED LIST INTO A SINGLE SORTED LINKED LIST.
    public static ListNode merge(ListNode head1,ListNode head2)
    {
        ListNode newHead = null,newTail = null;
        
        while(head1 != null && head2 != null)
        {
            if(head1.val < head2.val)
            {
                ListNode temp = head1;
                head1 = head1.next;
                temp.next = null;
                
                if(newHead == null)
                {
                    newHead = temp;
                    newTail = temp;
                }
                else
                {
                    newTail.next = temp;
                    newTail = newTail.next;
                }
            }
            else
            {
                ListNode temp = head2;
                head2 = head2.next;
                temp.next = null;
                
                if(newHead == null)
                {
                    newHead = temp;
                    newTail = temp;
                }
                else
                {
                    newTail.next = temp;
                    newTail = newTail.next;
                }
            }
        }
        
        while(head1 != null)
        {
            ListNode temp = head1;
            head1 = head1.next;
            temp.next = null;
            
            if(newHead == null)
            {
                newHead = temp;
                newTail = temp;
            }
            else
            {
                newTail.next = temp;
                newTail = newTail.next;
            }
        }
        
        while(head2 != null)
        {
            ListNode temp = head2;
            head2 = head2.next;
            temp.next = null;
            
            if(newHead == null)
            {
                newHead = temp;
                newTail = temp;
            }
            else
            {
                newTail.next = temp;
                newTail = newTail.next;
            }
        }
        
        return newHead;
    }
    
    // FUNCTION TO SORT THE GIVEN LINKED LIST.
    public static ListNode mergeSort(ListNode node)
    {
        if(node.next != null)
        {
            ListNode fast = node,slow = node;
            while(fast.next != null && fast.next.next != null)
            {
                fast = fast.next.next;
                slow = slow.next;
            }
            
            ListNode head = slow.next;
            slow.next = null;
            
            ListNode h1 = mergeSort(node);
            ListNode h2 = mergeSort(head);
            
            return merge(h1,h2);
        }
        
        return node;
    }
    
    public ListNode sortList(ListNode head) 
    {
        if(head == null)
        {
            return head;
        }
        
        return mergeSort(head);
    }
}

// TIME COMPLEXITY : O(N LOG N)
// SPACE COMPLEXITY : O(1)
