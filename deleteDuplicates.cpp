// THE PROBLEM STATEMENT IS TO RETURN THE GIVEN SORTED LINKED LIST WITHOUT ANY DUPLICATE VALUES.
// I.E IF THE GIVEN SORTED LINKED LIST IS [ 1 -> 2 -> 3 -> 4 -> 4 ] THEN WE HAVE TO RETURN [ 1 -> 2 -> 3 ]

// MY APPROACH IS TO CARRY OUT THE GIVEN PROBLEM WITHOUT TAKING ANY EXTRA SPACE. FIRSTLY, WE ARE DECLARING THREE POINTERS H,T,P WHERE H AND T REPRESENTS THE
// HEAD AND TAIL OF THE NEW LINKED LIST, AND P REPRESENTS PREVIOUS NODE OF A PARTICULAR ITERATION. SO, WE THEN TRAVERSE THE GIVEN LIST, WHILE 
// TRAVERSING WE CHECK IF THE CURRENT NODE'S VALUE IS NOT EQUAL TO THE PREVIOUS OR THE NEXT NODE, IF IT ISN'T THEN WE INSERT THE CURRENT NODE INTO THE NEW LINKED LIST.

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) 
    {
        ListNode* h = NULL;
        ListNode* t = NULL;
        ListNode* p = NULL; 
        
        // TRAVERSING THE GIVEN SORTE LINKED LIST.
        while(head != NULL)
        {
            if((p != NULL && p->val == head->val) || (head->next != NULL && head->next->val == head->val))
            {
                p = head;
                head = head->next;
            }
            else
            {
                ListNode* temp = head;
                head = head->next;
                temp->next = NULL;
                p = temp;
                
                if(h == NULL)
                {
                    h = temp;
                    t = temp;
                }
                else
                {
                    t->next = temp;
                    t = temp;
                }
            }
        }
        
        return h;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
