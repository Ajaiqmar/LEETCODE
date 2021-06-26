class Solution {
    
    public int lengthOfTheNode(TreeNode root)
    {
        if(root!=null)
        {
            return 1+Math.max(this.lengthOfTheNode(root.left),this.lengthOfTheNode(root.right));
        }
        return 0;
    }
    
    public int inorderTraversal(TreeNode root)
    {
        if(root!=null)
        {
            return Math.max(this.inorderTraversal(root.left),Math.max(this.lengthOfTheNode(root.left)+this.lengthOfTheNode(root.right),this.inorderTraversal(root.right)));
        }
        return 0;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter = this.inorderTraversal(root);
        return diameter;
    }
}
