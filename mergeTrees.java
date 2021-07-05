class Solution {
    public static TreeNode postOrder(TreeNode root1,TreeNode root2)
    {
        if(root1 == null && root2 == null)
        {
            return null;
        }
        else if(root1 == null)
        {
            root2.left = postOrder(root1,root2.left);
            root2.right = postOrder(root1,root2.right);
            return root2;
        }
        else if(root2 == null)
        {
            root1.left = postOrder(root1.left,root2);
            root1.right = postOrder(root1.right,root2);
            return root1;
        }
        else
        {
            root1.left = postOrder(root1.left,root2.left);
            root1.right = postOrder(root1.right,root2.right);
            root1.val += root2.val;
            return root1;
        }
    }
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) 
    {
        TreeNode mergedRoot = postOrder(root1,root2);
        return mergedRoot;
    }
}
