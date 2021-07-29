// THE PROBLEM STATEMENT IS TO FIND THE MIDDLE NODE IN A LINKED LIST.
// MY APPROACH IS TO TRAVERSE THE LINKED LIST ONCE TO  FIND OUT THE NUMBER OF NODES IN THE LINKED LIST.
// THEN TRAVERSE IT AGAIN TO IDENTIFY THE CENTER.

// FOLLOW UP : WE COULD ALSO DO IT IN A SINGLE TRAVERSAL WITH THE HELP OF RECURSION AND GLOBAL VARIABLES.

// STRUCTURE OF THE LINKED LIST NODE IS
// struct ListNode{
//  int val;
//  struct ListNode* next;
// }

struct ListNode* middleNode(struct ListNode* head)
{
    int countOfNodes = 0,currNodeCount = 0;
    struct ListNode* temp = head;
    
    // FIRST TRAVERSAL
    while(temp != NULL)
    {
        countOfNodes++;
        temp = temp->next;
    }
    
    temp = head;
    
    // SECOND TRAVERSAL
    while(currNodeCount != (countOfNodes/2))
    {
        currNodeCount++;
        temp = temp->next;
    }
    
    return temp;
    // MIDDLE ELEMENT
}

// TIME COMPLEXITY : O(2N) - SINCE, CONSTANTS WON'T MAKE ANY DIFFERENCE FOR HIGH CONSTRAINT VALUES. THE TIME COMPLEXITY IS O(N).
// SPACE COMPLEXITY : O(1).
