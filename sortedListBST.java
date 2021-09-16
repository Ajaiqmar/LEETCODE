// THE PROBLEM STATEMENT IS TO RETURN THE ROOT OF THE BINARY SEARCH TREE FORMED USING THE GIVEN SORTED LINKED LIST.

// MY APPROACH IS TO USE THE MODIFIED VERSION OF BINARY SEARCH ALONG WITH RECURSION IN THE FUNCTION CREATEBST. IN THE FUNCTION, FIRST WE WILL CHECK IF LEFT
// IS LESS THAN OR EQUAL TO RIGHT, IF IT IS WE WILL FIND THE MIDDLE ELEMENT OF THAT SUBARRAY AND WE WILL CREATE A TREENODE USING VALUE AND RETURN IT.
// THEN CREATE TWO FUNCTION CALLS TAKING THE LEFT AND RIGHT SUBARRAY OF THE GIVEN SUBARRAY.

// IT WORKS LIKE THIS :
// -10 -3 0 5 9

//        0
//       / \
//    -10   5
//       \   \
//       -3   9

class Solution 
{
    // FUNCTION TO CREATE THE BINARY SEARCH TREE USING THE BINARY SEARCH AND RECURSION.
    public static TreeNode createBST(int[] nums,int left,int right)
    {
        if(left <= right)
        {
            int middle = left+((right-left)/2);
            
            TreeNode node = new TreeNode(nums[middle]);
            node.left = createBST(nums,left,middle-1);
            node.right = createBST(nums,middle+1,right);
            
            return node;
        }
        
        return null;
    }
    
    public TreeNode sortedListToBST(ListNode head) 
    {
        int noOfNodes = 0;
        ListNode temp = head;
        
        while(temp != null)
        {
            temp = temp.next;
            noOfNodes += 1;
        }
        
        int[] arr = new int[noOfNodes];
        temp = head;
        for(int i=0;i<noOfNodes;i++)
        {
            arr[i] = temp.val;
            temp = temp.next;
        }
        
        return createBST(arr,0,noOfNodes-1);
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF NODES IN NUMS
// SPACE COMPLEXITY : O(1)
