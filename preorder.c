// THE PROBLEM STATEMENT IS TO DO AN PREORDER TRAVERSAL OF THE GIVEN N-ARY TREE.

// FOLLOW UP QUESTION IS TO DO IT IN AN ITERATIVE FASHION.

// MY APPROACH IS TO USE A STACK AND INSERT THE ROOT OF
// THE N-ARY TREE ONTO THE STACK. THEN ITERATIVELY REMOVE THE TOP ELEMENT OF THE STACK AND INSERT ITS CHILDREN ONTO THE STACK FROM RIGHT TO LEFT.
// WE CAN'T USE A QUEUE BECAUSE EVERY TIME WE REMOVE AN ELEMENT ITS LEFT POINTER SHOULD BE THE NEXT ONE TO BE REMOVED.

// STRUCTURE OF THE STACK
struct node{
    struct Node* val;
    struct node* next;
};

// FUNCTION TO CREATE A NODE
struct node* createNode(struct Node* root)
{
    struct node* temp = (struct node*)malloc(sizeof(struct node));
    temp->val = root;
    temp->next = NULL;
    
    return temp;
}

int* preorder(struct Node* root, int* returnSize) 
{
    // HEAD OF THE STACK.
    struct node* head = createNode(root);
    int* ans = malloc(sizeof(int)*10001);
    int size = 0;
    
    if(root == NULL)
    {
        *returnSize = size;
        return ans;
    }
    
    // DFS TRAVERSAL USING STACK DATA STRUCTURE IN AN ITERATIVE APPROACH.
    while(head != NULL)
    {
        struct node* ptr = head;
        head = head->next;
        
        ans[size++] = ptr->val->val;
        for(int i=(ptr->val->numChildren-1);i>=0;i--)
        {
            struct node* temp = createNode(ptr->val->children[i]);
            if(head == NULL)
            {
                head = temp;
            }
            else
            {
                temp->next = head;
                head = temp;
            }
        }
        
        free(ptr);
    }
    
    *returnSize = size;
    
    return ans;
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES IN THE N-ARY TREE.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE N-ARY TREE.
