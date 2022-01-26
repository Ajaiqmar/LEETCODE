// PROBLEM DESCRIPTION : https://leetcode.com/problems/reverse-nodes-in-k-group/

// MY APPROACH IS TO FIRST FIND OUT THE NUMBER OF ELEMENTS IN THE GIVEN LINKED LIST, THEN FIND OUT NUMBER OF SEGMENTS THAT CONTAINS K ELEMENTS. FINALLY TRAVERSE THE
// THE SEGMENTS THEN REVERSE THE ARRAY WITHOUT USING ANY EXTRA SPACE. WE NEED TO KEEP IN CHECK OF EACH SEGMENTS HEAD AND TAIL INORDER TO CONNECT THEM AFTER
// REVERSING THEM.

class Solution
{
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode temp = head;
        int n = 0;
        
        // FINDING OUT THE NUMBER OF ELEMENTS IN THE GIVEN LINKED LIST.
        while(temp != null)
        {
            temp = temp.next;
            n += 1;
        }
        
        // M REPRESENTS THE NUMBER OF SEGMENTS THAT HAVE K ELEMENTS.
        int m = n/k;
        ListNode prevTail = null;
        ListNode prevNode = null;
        ListNode currNode = head;
        
        // TRAVERSING EACH SEGMENTS
        while(m > 0)
        {
            int t = k;
            temp = currNode;
            
            // REVERSING EACH SEGMENT
            while(t > 0)
            {
                ListNode te = currNode;
                currNode = currNode.next;
                te.next = prevNode;
                prevNode = te;
                
                t -= 1;
            }
            
            if(prevTail != null)
            {
                prevTail.next = prevNode;
            }
            
            prevTail = temp;
            
            if(m == n/k)
            {
                head = prevNode;
            }
            
            prevNode = null;
            m -= 1;
        }
        
        if(prevTail != null)
        {
            prevTail.next = currNode;
        }
        
        return head;
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF ELEMENTS IN THE GIVEN LINKED LIST.
// SPACE COMPLEXITY : O(1)
