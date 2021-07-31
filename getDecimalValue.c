// THE PROBLEM STATEMENT IS TO RETURN THE DECIMAL VALUE OF THE BINARY REPRESENTATION USING LINKED LIST.

// MY APPROACH IS TO TRAVERSE THE LINKED LIST ONCE TO FIND THE BITVALUE WHICH WILL BE EQUAL TO TWO TO THE POWER OF LENGTH OF 
// LINKED LIST MINUS ONE. AND THEN TRAVERSE IT ONCE AGAIN TO CHECK FOR THE NODES WHOSE VALUE IS ONE.IF IT IS ONE ADD THE BITVALUE TO THE ANSWER AND DIVIDE THE BITVALUE BY
// 2, ELSE DIVIDE THE BITVALUE BY 2 AND MOVE TO THE NEXT NODE.

int getDecimalValue(struct ListNode* head)
{
    int bitValue = 1,ans = 0;
    struct ListNode* temp = head;
    
    // TRAVERSE THE LINKED LIST ONCE TO FIND THE BITVALUE.
    while(temp != NULL)
    {
        temp = temp->next;
        bitValue *= 2;
    }
    
    temp = head;
    bitValue = bitValue/2;
    
    // TRAVERSE THE LINKED LIST ONCE AGAIN TO FIND THE DECIMAL VALUE.
    while(temp != NULL)
    {
        if(temp->val == 1)
        {
            ans += bitValue;
        }
        temp = temp->next;
        bitValue = bitValue/2;
    }
    
    return ans;
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
