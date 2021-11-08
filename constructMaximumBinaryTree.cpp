// THE PROBLEM STATEMENT IS TO CREATE A MAXIMUM BINARY TREE USING THE GIVEN INTEGER ARRAY.
// I.E. LET SAY THE GIVEN INTEGER ARRAY IS [3,2,1,6,0,5]
// NOW THE ROOT OF THE BINARY TREE IS THE MAXIMUM VALUE OF THE INITIAL ARRAY, THEN THE ARRAY IS DIVIDED INTO TWO SUBARRAYS.
// IN THE GIVEN ARRAY, THE ROOT IS 6 AND THE SUBARRAYS ARE [3,2,1] AND [0,5]. NOW WE FIND THE MAXIMUM OF THESE ARRAYS AND THIS WILL BE THE RIGHT
// AND LEFT CHILD OF THE ROOT, SIMILARLY, WE HAVE TO BUILD THE MAXIMUM BINARY TREE.
// THE MAXIMUM BINARY TREE FOR THE GIVEN ARRAY IS:
//            6
//         /     \
//        3       5
//         \     /
//          2   0
//           \
//            1

// MY APPROACH IS TO CONSTRUCT THE MAXIMUM BINARY TREE USING THE DIVIDE AND CONQUER APPROACH. FIRSTLY, CREATE A RECURSIVE FUNCTION, WHICH CONTAINS THE
// PARAMETERS AS THE GIVEN ARRAY(ARR) AND TWO INTEGERS REPRESENTING THE FIRST(L) AND THE LAST(H) INDEX. SECONDLY, CHECK IF L <= H, THEN IF L == H,
// RETURN THE TREE NODE WITH VALUE AS ARR[L], ELSE FIND THE MAXIMUM OF THE GIVEN SUBARRAY AND ITS INDEX, THEN CREATE A TREE NODE WITH THE MAXIMUM VALUE,
// ASSIGN THE LEFT POINTER TO A RECURSIVE FUNCTION CALL TO THE LEFT SUBTREE AND ASSIGN THE RIGHT POINTER TO A RECURSIVE FUNCTION CALL TO THE RIGHT SUBTREE
// KEEPING MAXIMUM VALUES INDEX AS THE PIVOT. FINALLY, RETURN THE TREE NODE.

class Solution 
{
public:
    // FUNCTION TO CONSTRUCT THE MAXIMUM BINARY TREE USING DIVIDE AND CONQUER APPROACH.
    TreeNode* createMBT(vector<int>& nums,int l,int h)
    {
        if(l <= h)
        {
            if(l == h)
            {
                return new TreeNode(nums[l]);
            }
            
            int max = nums[l],ind = l;
            for(int i=l;i<=h;i++)
            {
                if(nums[i] > max)
                {
                    max = nums[i];
                    ind = i;
                }
            }
            
            TreeNode* node = new TreeNode(nums[ind],createMBT(nums,l,ind-1),createMBT(nums,ind+1,h));
            
            return node;
        }
        return NULL;
    }
    
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) 
    {
        return createMBT(nums,0,nums.size()-1);
    }
};

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N)

// INORDER TO REDUCE THE TIME COMPLEXITY, THERE IS AN EFFECTIVE APPROACH USING STACK DATA STRUCTURE.
// LINK : https://leetcode.com/problems/maximum-binary-tree/discuss/106146/C++-O(N)-solution
