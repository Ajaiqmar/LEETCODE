class Solution 
{
    static int countFromTail = 0;
    
    public static ListNode remove(ListNode curr_node,int n)
    {
        if(curr_node != null)
        {
            curr_node.next = remove(curr_node.next,n);
            countFromTail += 1;
            
            if(countFromTail == n)
            {
                return curr_node.next;
            }
            
            return curr_node;
        }
        return null;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        countFromTail = 0;
        
        head = remove(head,n);
        
        return head;
    }
}
