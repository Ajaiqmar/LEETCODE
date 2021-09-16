// THE PROBLEM STATEMENT IS TO ROTATE THE GIVEN LINKED LIST ANTI-CLOCKWISE BY K NODES.

// MY APPROACH IS TO FIRST COUNT THE NUMBER OF NODES IN THE GIVEN LINKED LIST, THEN MAKE SURE THAT K IS LESS THAN THE NUMBER OF NODES INORDER TO AVOID REPETITION,
// IF K OR NUMBER OF NODES IS ZERO, RETURN THE HEAD, ELSE TRAVERSE THE LINKED LIST TO FIND THE NEW HEAD AND NEW TAIL OF THE LINKED LIST AT (NUMBER OF NODES - K)-TH 
// POSITION. THEN INITIALISE THE NEXT VALUE THE NEW TAIL TO NULL, ALSO INITIALISE THE GIVEN TAIL NODE TO POINT TO GIVEN HEAD.

class Solution 
{
    public ListNode rotateRight(ListNode head, int k) 
    {
        ListNode temp = head;
        int noOfNodes = 0;
        
        // FINDING THE NUMBER OF NODES IN THE GIVEN LINKED LIST.
        while(temp != null)
        {
            noOfNodes += 1;
            temp = temp.next;
        }
        
        if(noOfNodes == 0)
        {
            return head;
        }
        
        k = k%noOfNodes;
        
        if(k == 0)
        {
            return head;
        }
        
        int n = noOfNodes-k;
        ListNode curr = head;
        ListNode prev = null;
        
        // TRAVERSING THE GIVEN LINKED LIST TO FIND THE NEW HEAD AND NEW TAIL.
        while(n > 0)
        {
            prev = curr;
            curr = curr.next;
            n -= 1;
        }
        
        prev.next = null;
        ListNode h = curr;
        ListNode t = curr;
        
        while(t.next != null)
        {
            t = t.next;
        }
        
        t.next = head;

        return h;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
