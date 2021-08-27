// THE PROBLEM STATEMENT IS TO CHECK WHETHER THE GIVEN BINARY TREE IS A BINARY SEARCH TREE.

// MY APPROACH IS TO DO AN INORDER TRAVERSAL WHICH WILL TRAVERSE THE ELEMENTS IN ASCENDING ORDER IF IT IS A VALID BINARY SEARCH TREE, STORE THIS ELEMENTS ONTO THE ARRAY
// THEN CHECK IF THE ARRAY IS IN THE ASCENDING FORMAT.

class Solution 
{
private:
    vector<int> arr;
public:
    // FUNCTION TO TRAVERSE THE BINARY TREE.
    void inorderTraversal(TreeNode* root)
    {
        if(root != NULL)
        {
            inorderTraversal(root->left);
            arr.push_back(root->val);
            inorderTraversal(root->right);
        }
    }
    
    bool isValidBST(TreeNode* root) 
    {
        inorderTraversal(root);
        
        for(int i=1;i<arr.size();i++)
        {
            if(arr[i] <= arr[i-1])
            {
                return false;
            }
        }
        
        return true;
    }
};

// TIME COMPLEXITY : O(2*N) WHERE N IS THE NUMBER OF NODES IN THE BINARY TREE.
// SPACE COMPLEXITY : O(MAX(N,H)) WHERE H IS THE HIEGHT OF THE BIBARY TREE AND N IS THE SIZE OF THE ARRAY TO STORE THE ELEMENTS OF THE BINARY TREE.
