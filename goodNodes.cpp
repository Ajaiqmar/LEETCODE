// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF GOOD NODES IN A BINARY TREE. A NODE IS CONSIDERED TO BE GGOD IF ITS VALUE IS THE HIGHEST VALUE
// AMONG THE VALUES IN ITS PATH FROM THE ROOT.

// MY APPROACH IS TO DO A DFS TRAVERSAL WHILE TRAVERSING KEEP IN CHECK OF MAXIMUM VALUE IN ITS PATH, IF THE CURRENT NODE VALUE IS GREATER THE MAX VALUE
// OF ITS PATH THEN IT IS CONSIDERED TO BE A GOOD NODE.

class Solution {
public:
    // TRAVERSING THE BINARY TREE USING DFS TRAVERSAL.
    void preorder(TreeNode* root,int* gn,int max)
    {
        if(root != NULL)
        {
            // CHECKING FOR THE GOOD NODES.
            if(root->val >= max)
            {
                *gn += 1;
                max = root->val;
                cout << root->val << endl;
            }
            
            preorder(root->left,gn,max);
            preorder(root->right,gn,max);
        }
    }
    
    int goodNodes(TreeNode* root) 
    {
        int noOfGoodNodes = 0;
        
        preorder(root,&noOfGoodNodes,root->val);
        
        return noOfGoodNodes;
    }
};

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE TREE.
