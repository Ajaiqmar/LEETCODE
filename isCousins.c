// THE PROBLEM STATEMENT IS TO FIND WHETHER THE GIVEN VALUE OF NODES ARE COUSINS. TWO NODES ARE CALLED AS COUSINS. IF THEY HAVE
// THE SAME DEPTH BUT DIFFERENT PARENT NODE.

// MY APPRAOCH IS TO DO A DFS APPROACH AND IF THE NODE VALUE MATCHES THE VALUE OF X OR Y, THEN NOTE DOWN THE DEPTH OF THE NODE 
// AND THE VALUE OF THE PARENT NODE. SINCE EVERY VALUE OF THE NODE IN THE BINARY TREE IS DISTINCT. WE JUST HAVE TO CHECK IF THE DEPTH ARE EQUAL
// AND PARENT VALUES ARE NOT EQUAL.

// DFS TRAVERSAL - (INORDER TRAVERSAL)
void inorder(struct TreeNode* root,struct TreeNode* parent,int x,int y,int depth,int* depthx,int* depthy,int* parentx,int* parenty)
{
    if(root != NULL)
    {
        inorder(root->left,root,x,y,depth+1,depthx,depthy,parentx,parenty);
        // CHECKING IF THE NODE VALUE IS EQUAL TO THE VALUES OF X OR Y.
        if(x == root->val)
        {
            *depthx = depth;
            if(parent != NULL)
            {
                *parentx = parent->val;
            }
        }
        else if(y == root->val)
        {
            *depthy = depth;
            if(parent != NULL)
            {
                *parenty = parent->val;
            }
        }
        inorder(root->right,root,x,y,depth+1,depthx,depthy,parentx,parenty);
    }
}

bool isCousins(struct TreeNode* root, int x, int y)
{
    int depthx = -1,depthy = -1,parentx = -1,parenty = -1;
    
    inorder(root,NULL,x,y,0,&depthx,&depthy,&parentx,&parenty);
    
    // CHECKING WHETHER THE DEPTH OF THE NODES ARE EQUAL AND THE VALUE OF THE PARENT NODES ARE EQUAL.
    return ((depthx == depthy) && (parentx != parenty));
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
