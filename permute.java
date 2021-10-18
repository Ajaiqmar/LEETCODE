// THE PROBLEM STATEMENT IS TO RETURN A LIST OF ALL POSSIBLE PERMUTATIONS OF THE GIVEN ARRAY.

// MY APPROACH IS TO USE BACKTRACKING APPROACH, IN THIS APPROACH, WE CREATE A RECURSIVE TREE IN WHICH AT EACH NODE WE SWAP THE CURRENT ELEMENTS INDEX WITH THE
// EVERY ELEMENTS INDICES IN THE MATRIX, THEN IF THE INDEX VALUE REACHES (LENGTH OF THE ARRAY-1), WE INSERT THE ARRAY ONTO THE ANS ARRAYLIST.

// I.E SAY IF THE GIVEN ARRAY IS [1,2,3]
// THE RECURSIVE TREE WOULD LOOK LIKE :

//                       [1,2,3]              FIRST, WE SWAP THE ELEMENT AT FIRST INDEX WITH ALL THE ELEMENTS.
//          /               |              \
//      [1,2,3]          [2,1,3]           [3,2,1]  SECONDLY, WE SWAP THE ELEMENT AT SECOND INDEX WITH ALL THE ELEMENTS.
//    /      \           /     \           /     \
// [1,2,3]  [1,3,2]  [2,1,3]  [2,3,1]  [3,2,1]  [3,1,2]  SINCE, THE INDEX REACHES (LENGTH OF ARRAY-1) WE INSERT EVERY ARRAY ONTO THE ANS ARRAY.



class Solution 
{
    // FUNCTION TO RECURSIVELY FIND ALL THE PERMUTATIONS OF THE GIVEN ARRAY
    public static void perm(int[] nums,int ind,List<List<Integer>> ans)
    {
        if(ind == (nums.length-1))
        {
            List<Integer> arr = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++)
            {
                arr.add(nums[i]);
            }
            ans.add(arr);
        }
        
        // SWAPPING CURRENT INDEX VALUE WITH EVERY OTHER INDEX IN THE ARRAY.
        for(int i=ind;i<nums.length;i++)
        {
            int temp = nums[ind];
            nums[ind] = nums[i];
            nums[i] = temp;
            perm(nums,ind+1,ans);
            temp = nums[ind];
            nums[ind] = nums[i];
            nums[i] = temp;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        perm(nums,0,ans);
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*N!)
// SPACE COMPLEXITY : O(N!*N) WHERE (N*N!) IS THE DIMENSIONS FOR THE ANS ARRAY. 
