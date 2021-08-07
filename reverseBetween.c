//  THE PROBLEM STATEMENT IS TO REVERSE THE NODES OF THE LINKED LIST BETWEEN LEFT AND RIGHT NODES (INCLUSIVE OF LEFT AND RIGHT NODES) IN THE GIVEN LINKED LIST.

// FOLLOW UP QUESTION TO SOLVE IT IN ONE PASS.

// MY APPROACH IS TO TRAVERSE THE LINKED LIST UP TILL THE LEFT COUNT(HEAD OF THE SMALLER LINKED LIST) AND NOTE DOWN THE PREVIOUS NODE OF THE HEAD AS WELL.
// AND THEN START REVERSING THE LINKED LIST USING THE WHILE LOOP BY CHANGING THE NEXT NODES POINTER TO POINT TO CURRENT NODE RIGHT UNTIL THE COUNT HAS REACHED THE 
// RIGHT VALUE(TAIL OF THE SMALLER LINKED LIST). THEN MAKE SURE TO NOTE DOWN THE NEXT NODE OF THE RIGHT COUNT. NOW CHANGE THE PREVIOUS NODE OF THE LEFT
// NODE TO POINT TO THE TAIL AND THE HEAD NODES POINTER TO POINT TO THE NEXT NODE OF THE TAIL. 

// (PS: I KNOW THE EXPLANATION IS A LITTLE MESSED UP. PING ME, IF YOU WANT A LITTLE BIT MORE CLEAR VERSION OF IT.)

struct ListNode* reverseBetween(struct ListNode* head, int left, int right)
{
    struct ListNode* temp = head;
    struct ListNode* pre_h = NULL;
    // HEAD OF THE SMALLER LINKED LIST.
    struct ListNode* h = NULL;
    // TAIL OF THE SMALLER LINKED LIST.
    struct ListNode* t = NULL;
    struct ListNode* pos_t = NULL;
    int countOfNode = 1;
    
    // TRAVERSING TILL THE HEAD OF THE SMALLER LINKED LIST.
    while(countOfNode < left)
    {
        countOfNode += 1;
        pre_h = temp;
        temp = temp->next;
    }
    
    h = temp;
    struct ListNode* prev = NULL;
    
    // REVERSING THE SMALLER LINKED LIST.
    while(countOfNode < right)
    {
        countOfNode += 1;
        struct ListNode* ptr = temp;
        temp = temp->next;
        ptr->next = prev;
        prev = ptr;
    }
    
    // POSITIONING THE SMALLER LINKED LIST INTO THE BIGGER LINKED LIST.
    t = temp;
    pos_t = temp->next;
    temp->next = prev;
    if(pre_h != NULL)
    {
        pre_h->next = t;
    }
    else
    {
        head = t;
    }
    h->next = pos_t;
    
    return head;
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
