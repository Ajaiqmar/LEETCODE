// DIAMETER OF A BINARY TREE - MAXIMUM NUMBER OF EDGES BETWEEN TWO NODES 
// APPROACH - FINDING THE LENGTH OF THE LEFT AND RIGHT SUB-TREE FOR EACH NODE AND RETURNING THE MAXIMUM ONE

class Solution {
    
    public int lengthOfTheNode(TreeNode root)
    {
        if(root!=null)
        {
            return 1+Math.max(this.lengthOfTheNode(root.left),this.lengthOfTheNode(root.right));
        }
        return 0;
    }
    
    public int Traversal(TreeNode root)
    {
        if(root!=null)
        {
            return Math.max(this.inorderTraversal(root.left),Math.max(this.lengthOfTheNode(root.left)+this.lengthOfTheNode(root.right),this.inorderTraversal(root.right)));
        }
        return 0;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter = this.Traversal(root);
        return diameter;
    }
}
