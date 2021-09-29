// THE PROBLEM STATEMENT IS TO SPLIT THE THE GIVEN LINKED LIST INTO K PARTS AND RETURN THE HEAD OF EACH LINKED LIST AS AN ARRAY. THE LENGTH OF EACH LINKED LIST
// DIFFERS IN LENGTH BY ATMOST 1 TO THE ADJACENT LINKED LIST. THE LINKED LIST WHEN CONNECTED CAN RECREATE THE GIVEN LINKED LIST.

// MY APPROACH IS TO FIND THE NUMBER OS SEGMENTS AND NUMBER OF RESIDUAL NODES. SINCE THENUMBER OF NODES IS NOT ALWAYS GOING TO BE DIVISIBLE BY K, WE NEED TO
// KNOW ABOUT THE RESIDUAL NODES, THE NUMBER OF RESIDUAL NODES IS THE SAME NUMBER OF LINKED LIST WHICH ARE GOING HAVE (N/K)+1 NODES IN THEIR LINKED
// LIST WHERE N IS THE NUMBER OF NODES AND K THE NUMBER OF PARTS IT NEEDED TO BE SPLIT. NOW AFTER CALCULATING THE ABOVE VALUES,
// WE TRAVERSE THE LINKED LIST, UNTIL THE NUMBER OF RESIDUAL NODES COUNT IS ZERO, WE WILL BE CREATING A LINKED LIST OF LENGTH (N/K)+1 AND 
// ADDING THEIR HEAD TO THE ANS ARRAY. THEN WE WILL BE CREATING AND ADDING THE LINKED LIST OF LENGTH (N/K).

// I.E. Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
//      Output: [[1,2,3,4],[5,6,7],[8,9,10]]

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) 
    {
        ListNode[] ans = new ListNode[k];
        int n = 0;
        ListNode temp = head;
        
        // FINDIN THE NUMBER OF NODES IN THE GIVEN LINKED LIST. 
        while(temp != null)
        {
            n += 1;
            temp = temp.next;
        }
        
        int ind = 0,segment = n%k;
        temp = head;
        // SPLITTING THE GIVEN LINKED LIST INTO K PARTS.
        while(temp != null)
        {
            int c = n/k;
            if(segment > 0)
            {
                ans[ind] = temp;
                c += 1;
                while(c > 0)
                {
                    if(c == 1)
                    {
                        ListNode ptr = temp;
                        temp = temp.next;
                        ptr.next = null;
                    }
                    else
                    {
                        temp = temp.next;
                    }
                    c -= 1;
                }
                ind += 1;
                segment -= 1;
            }
            else
            {
                ans[ind] = temp;
                while(c > 0)
                {
                    if(c == 1)
                    {
                        ListNode ptr = temp;
                        temp = temp.next;
                        ptr.next = null;
                    }
                    else
                    {
                        temp = temp.next;
                    }
                    c -= 1;
                }
                ind += 1;
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES IN THE LINKED LIST.
// SPACE COMPLEXITY : O(K)
