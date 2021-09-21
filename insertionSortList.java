// THE PROBLEM STATEMENT IS TO SORT THE GIVEN LINKED LIST USING INSERTION SORT. 

// THE BASIC STEP OF INSERTION SORT IS TO CONSIDER A VALUE IN THE ARRAY AND
// MOVE THE VALUE TOWARDS LEFT UNTIL THE CURRENT VALUE IS LESSER THAN THE PREVIOUS VALUE. SINCE WE WOULD HAVE NO VISIBLITY OF THE PREVIOUS NODES
// IN A SINGLY LINKED LIST, MY VIEWS IS TO STORE THE NODES IN AN ARRAY AND THEN SORT THE ARRAY ACCORDING THE VALUE OF THE NODE AND THEN RECREATE THE LINKED LIST.

class Solution 
{
    public ListNode insertionSortList(ListNode head) 
    {
        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        
        // TRAVERSING THE LINKED LIST AND STORING THE NODES IN THE ARRAY.
        while(head != null)
        {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            
            arr.add(temp);
        }
        
        // SORTING THE ARRAY USING INSERTION SORT.
        for(int i=1;i<arr.size();i++)
        {
            int curr = i;
            for(int j=i-1;j>=0;j--)
            {
                ListNode node1 = arr.get(curr);
                ListNode node2 = arr.get(j);
                
                if(node1.val < node2.val)
                {
                    arr.set(curr,node2);
                    arr.set(j,node1);
                    curr = j;
                }
            }
        }
        
        ListNode tail = null;
        
        // RECREATING THE SORTED LINKED LIST FROM THE SORTED ARRAY.
        for(int i=0;i<arr.size();i++)
        {
            if(head == null)
            {
                head = arr.get(i);
                tail = arr.get(i);
            }
            else
            {
                tail.next = arr.get(i);
                tail = tail.next;
            }
        }
        
        return head;
    }
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N)
