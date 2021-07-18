class Solution {
    public static void inorder(TreeNode root,ArrayList<Integer> leafNodes,int index)
    {
        if(root != null)
        {
            inorder(root.left,leafNodes,index);
            if(root.left == null && root.right == null)
            {
                leafNodes.add(root.val);
            }
            inorder(root.right,leafNodes,index);
        }
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leafNodes1 = new ArrayList<Integer>();
        ArrayList<Integer> leafNodes2 = new ArrayList<Integer>();
        
        inorder(root1,leafNodes1,0);
        inorder(root2,leafNodes2,0);
        
        if(leafNodes1.size()!=leafNodes2.size())
        {
            return false;
        }
        
        for(int i=0;i<leafNodes1.size();i++)
        {
            if(leafNodes1.get(i) != leafNodes2.get(i))
            {
                return false;
            }
        }
        
        return true;
    }
}
