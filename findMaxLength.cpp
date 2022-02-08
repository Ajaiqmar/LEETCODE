// PROBLEM DESCRIPTION : https://leetcode.com/problems/contiguous-array/

// MY APPROACH IS TO FRIST TRAVERSE THE ARRAY, WHILE TRAVERSING INCREMENT THE VALUE OF D IF THE CURRENT VALUE IN THE ARRAY IS 1 ELSE DECREMNT THE VALUE OF D,
// SO FOR EACH ITERATION LOG THE VALUES INTO THE HASHMAP OR UNORDERED MAP IN THIS CASE. IF THE VALUE ALREADY EXISTS THEN FIND THE DIFFERENCE BETWEEN CURRENT INDEX
// AND THE STORED INDEX. THIS WILL HELP TO FIND THE MAXIMUM SUBARRAY WITH EQUAL NUMBER OF 1 AND 0. ALSO CHECK WHETHER D REACHES 0 DURING THE TRAVERSAL WHICH IS 
// A SPECIAL CASE AND IT INDICATES THAT THE STARTING INDEX OF THAT SUBARRAY WITH EQUAL NYUMBER OF 1 AND 0 IS 0.

class Solution {
    public:
        int findMaxLength(vector<int>& nums) 
        {
            // INITIALISING THE HASHMAP.
            unordered_map<int,int> umap;
            int d = 0;
            int ans = 0;
            
            // TRAVERSING THE ARRAY
            for(int i=0;i<nums.size();i++)
            {
                if(nums[i] == 0)
                {
                    d -= 1;
                }
                else
                {
                    d += 1;
                }
                
                if(umap.find(d) == umap.end())
                {
                    umap[d] = i;
                }
                else
                {
                    ans = max(ans,i-umap[d]);
                }
                
                if(d == 0)
                {
                    ans = max(ans,(i+1));
                }
            }
            
            return ans;
        }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
