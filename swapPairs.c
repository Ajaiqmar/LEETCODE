// THE PROBLEM STATEMENT IS TO SWAP EVERY TWO ADJACENT NODES IN A LINKED LIST.

// MY APPROACH IS TO FIRST CHECK THE NUMBER OF NODES IN THE LINKED LIST IS GREATER THAN ONE.
// THEN CHANGE THE HEAD OF THE LIST TO POINT TO THE THIRD ELEMENT AND THE SECOND ELEMENT TO POINT TO THE HEAD. NOW CHANGE THE HEAD OF THE LINKED 
// LIST AS THE SECOND NODE. THEN START FROM THE THIRD NODE AND REPEAT THE SAME PROCESS THAT HAS BEEN DONE TO THE FIRST TWO NODES USING A WHILE
// LOOP. ONE ADDITIONAL THING IS EVERY EVEN NODES NEXT ELEMENT (PREV) SHOULD BE CHANGED TO THE NEXT EVEN NODE.

struct ListNode* swapPairs(struct ListNode* head)
{
    // CHECKING IF THE LENGTH OF LINKED LIST IS GREATER THAN TWO.
    if(head == NULL || head->next == NULL)
    {
        return head;
    }
    
    // SWAPPING THE FIRST TWO NODES IN THE LINKED LIST.
    struct ListNode* temp = head->next->next;
    
    head->next->next = head;
    head = head->next;
    head->next->next = temp;
    
    // EVEN NODE IS BEING STORED IN THE PREV POINTER.
    struct ListNode* prev = head->next;
    
    while(temp != NULL && temp->next != NULL)
    {
        struct ListNode* ptr = temp->next->next;
        
        // SWAPPING THE CONSECUTIVE NODES IN THE LINKED LIST.
        temp->next->next = temp;
        temp = temp->next;
        temp->next->next = ptr;
        
        // MAKING SURE THAT THE EVEN POINTER POINTS TO THE NEXT EVEN NODE.
        prev->next = temp;
        prev = temp->next;
        temp = ptr;
    }
    
    return head;
}

// TIME COMPLEXITY : O(N/2) == O(N) WHERE N IS THE NUMBER OF NODES IN THE LINKED LIST.
// SPACE COMPLEXITY : O(1)
