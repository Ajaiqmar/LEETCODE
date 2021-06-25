class Solution {
    int minAbsoluteDifference;
    int prev;
    
    public void inorderTraversal(TreeNode root)
    {
        if(root != null)
        {
            this.inorderTraversal(root.left);
            this.minAbsoluteDifference = Math.min(this.minAbsoluteDifference, Math.abs(root.val - this.prev));
            this.prev = root.val;
            this.inorderTraversal(root.right);
        }
        return ;
    }
    
    public int getMinimumDifference(TreeNode root) {
        this.minAbsoluteDifference = Integer.MAX_VALUE;
        this.prev = Integer.MAX_VALUE;
        
        this.inorderTraversal(root);
        
        return this.minAbsoluteDifference;
    }
}
