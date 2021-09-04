// THE PROBLEM STATEMENT IS TO RETURN LIST OF ALL SUBSETS OF THE GIVEN ARRAY. I.E. IF THE GIVEN ARRAY IS [1,2,3] THEN WE HAVE TO RETURN
// [[],[1],[2],[3],[1,2],[1,3],[1,2,3]].

// MY APPROACH IS TO USE THE BIT MANIPULATION TECHNIQUE. HOW THE BIT MANIPULATION TECHNIQUE BASICALLY WORKS IS, INORDER TO FIND EVERY SUBSET OF THE GIVEN ARRAY,
// WE HAVE TO CONSIDER EVERY POSSIBLE LENGTH OF ARRAY UNTIL N WHERE N IS THE LENGTH OF THE GIVEN ARRAY AND EVERY POSSIBLE COMBINATIONS. INORDER TO ACHIEVE
// THIS, WE USE BINARY REPRESENTATION OF AN INTEGER. FIRST WE HAVE TO FIND THE SUM OF ALL THE POWER OF 2 FROM 0 TO N-1. THEN WE HAVE TO TRAVERSE FROM 
// 0 TO THE SUM, THEN WE HAVE TO FIND THEIR BINARY REPRESENTATION, IN THE BINARY REPRESENTATION IF THE VALUE IS 1 WE HAVE TO ADD THEIR RESPECTIVE ELEMENT TO THE
// ARRAY, THEN AT THE END OF EACH ITERATION ADD THAT LIST TO THE ANS ARRAY.

class Solution 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        int n = 0,power=1,len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        // FINDING THE SUM OF POWERS OF TWO FROM 0 TO N-1.
        while(len > 0)
        {
            n += power;
            power = power*2;
            len -= 1;
        }
        
        // TRAVERSING FROM 0 TILL THE SUM OF THE POWERS.
        for(int i=0;i<=n;i++)
        {
            int ind = 0,val = i;
            List<Integer> arr = new ArrayList<Integer>();
            
            // FINDING THEIR BINARY REPRESENTATION.
            while(val > 0)
            {
                if(val%2 == 1)
                {
                    arr.add(nums[ind]);
                }
                ind += 1;
                val = val/2;
            }
            
            ans.add(arr);
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N + M LOG M) WHERE N IS THE LENGTH OF THE ARRAY, AND M IS THE SUM ALL POWERS OF TWO FROM 0 TO N-1.
// SPACE COMPLEXITY : O(M*N) NO EXTRA SPACE IS REQUIRED, N*M IS THE DIMENSIONS OF THE TWO DIMENSIONAL ARRAY TO BE RETURNED.
