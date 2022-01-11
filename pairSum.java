// THE PROBLEM STATEMENT IS TO RETURN THE MAXIMUM TWIN SUM OF THE GIVEN ARRAY. THE TWIN SUM OF AN ARRAY IS AN ARRAY OF LENGTH N/2 WHERE EACH
// INDEX VALUE IS EQUAL TO, TWINSUM[I] = ARR[I]+ARR[N-I+1].

// MY APPROACH IS TO FIRST FIND THE NUMBER OF ELEMENTS IN THE LINKED LIST,THEN TRAVERSE ADD THE FIRST N/2 ELEMENTS IN A STACK, FINALLY, TRAVERSE
// THE LAST N/2 ELEMENTS WHILE TRAVERSING FIND THE TWIN SUM OF THAT INDEX BY ADDING THE STACK'S TOP ELEMENT WITH CURRENT LINKED LIST ELEMENT.
// FIND THE MAXIMUM TWIN SUM AND RETURN IT.

class Solution 
{
    public int pairSum(ListNode head)
    {
        int n = 0,ans = 0;
        ListNode temp = head;
        
        // FINDING THE NUMBER OF ELEMENTS IN THE LINKED LIST. 
        while(temp != null)
        {
            temp = temp.next;
            n += 1;
        }
        
        Stack<Integer> s = new Stack<Integer>();
        int m = 0;
        temp = head;
        
        // ADDING THE ELEMENTS ONTO THE STACK.
        while(m < (n/2))
        {
            s.push(temp.val);
            m += 1;
            temp = temp.next;
        }
        
        // FINDING THE TWIN SUM.
        while(m < n)
        {
            int twinSum = s.pop()+temp.val;
            temp = temp.next;
            m += 1;
            ans = Math.max(ans,twinSum);
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
