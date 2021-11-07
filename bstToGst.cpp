// THE PROBLEM STATEMENT IS TO CREATE A GREAT SUM TREE (GST) FROM THE GIVEN BINARY SEARCH TREE (BST). EACH NODE OF THE GREAT SUM TREE IS THE SUM OF THE CORRESPONDING
// NODE VALUE AND ALL THE OTHER NODE VALUES GREATER THAN THE CORRESPONDING NODE VALUE.

// MY APPROACH IS TO DO AN INORDER TRAVERSAL AND RETRIEVE THE VALUES OF THE BST IN ASCENDING ORDER, THEN TRAVERSAE THE ARRAY AND FIND THE SUFFIX SUM
// OF EACH INDEX. FINALLY, TRAVERSE THE BST AGAIN TO SET THE CORRESPONDING NODE VALUE AND RETURN THE ROOT OF THE TREE.

class Solution {
public:
    // FUNCTION TO TRAVERSE THE BST.
    void traversal(TreeNode* root,vector<int>& arr)
    {
        if(root != NULL)
        {
            traversal(root->left,arr);
            arr.push_back(root->val);
            traversal(root->right,arr);
        }
    }
    
    // FUNCTION TO SET CORRESPONG GST VALUE FOR EACH NODE IN THE BST.
    void setValue(TreeNode* root,vector<int>& arr,int* ind)
    {
        if(root != NULL)
        {
            setValue(root->left,arr,ind);
            root->val = arr[*ind];
            *ind += 1;
            setValue(root->right,arr,ind);
        }
    }
  
    TreeNode* bstToGst(TreeNode* root) 
    {
        vector<int> arr;
        traversal(root,arr);
        
        // FINDING SUFFIX SUM OF THE RETRIEVED ARRAY.
        for(int i=(arr.size()-2);i>=0;i--)
        {
            arr[i] += arr[i+1];
        }
        
        int ind = 0;
        setValue(root,arr,&ind);
        
        return root;
    }
};

// TIME COMPLEXITY : O(N)
// SPAVCE COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES.
