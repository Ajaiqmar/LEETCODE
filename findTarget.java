class Solution 
{
    public static boolean preOrder(TreeNode root, int k,HashMap<Integer,Integer> hm)
    {
        if(root != null)
        {
            if(hm.get(k-root.val) != null)
            {
                return true;
            }
            hm.put(root.val,1);
            return preOrder(root.left,k,hm) || preOrder(root.right,k,hm);
        }
        return false;
    }
    
    public boolean findTarget(TreeNode root, int k) 
    {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        return preOrder(root,k,hm);
    }
}
