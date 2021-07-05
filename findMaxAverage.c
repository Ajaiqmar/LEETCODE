struct Node{
    int data;
    int length;
    struct Node* next;
};

struct Node* head = NULL;
struct Node* tail = NULL;

void enqueue(int val)
{
    struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
    temp->data = val;
    temp->length = 0;
    temp->next = NULL;
    
    if(tail == NULL)
    {
        temp->length = 1;
        head = temp;
        tail = temp;
    }
    else
    {
        temp->length = tail->length+1;
        tail->next = temp;
        tail = temp;
    }
}

int dequeue()
{
    struct Node* temp = head;
    head = head->next;
    
    int val = temp->data;
    free(temp);
    
    return val;
}

int findLength()
{
    return (tail->length - head->length)+1;
}

void dequeueAll()
{
    while(head!=NULL)
    {
        struct Node* temp = head;
        head = head->next;
        free(temp);
    }
    head =NULL;
    tail = NULL;
}

double findMaxAverage(int* nums, int numsSize, int k){
    double sum = 0,l = k;
    double MaxAverage = INT_MIN;
    
    for(int i=0;i<numsSize;i++)
    {
        sum += nums[i];
        
        enqueue(nums[i]);
        
        if(findLength() == k+1)
        {
            int val = dequeue();
            sum -= val;
        }
        
        if(findLength() == k)
        {
            if((sum/l) > MaxAverage)
            {
                MaxAverage = sum/l;
            }
        }
    }
    
    dequeueAll();
    
    return MaxAverage;
}
