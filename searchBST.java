class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root != null)
        {
            if(val == root.val)
            {
                return root;
            }
            else if(val < root.val)
            {
                return this.searchBST(root.left,val);
            }
            else if(val > root.val)
            {
                return this.searchBST(root.right,val);
            }
        }
        return null;
    }
}
