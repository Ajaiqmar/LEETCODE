class Solution {
    static String ans = "";
    
    public static void preorder(TreeNode root)
    {
        if(root!=null)
        {
            ans+="("+root.val;
            if(root.left == null && root.right!=null)
            {
                ans+="()";
                preorder(root.right);
            }
            else
            {
                preorder(root.left);
                preorder(root.right);
            }
            ans+=")";
        }
    }
    
    public String tree2str(TreeNode root) {
        ans = "";
        preorder(root);
        
        return ans.substring(1,ans.length()-1);
    }
}
