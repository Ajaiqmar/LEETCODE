// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF EXPRESSION THAT EVALUATE TO THE VALUE TARGET, WHEN THE OPERANDS ARE GIVEN IN THE FORM OF ARRAY AND OPERATORS TO BE
// USED ARE '+' AND '-'.

// MY APPROACH IS TO USE A RECURSION WITH MEMOIZATION APPROACH TO ESTABLISH ALL THE POSSIBLE EXPRESSION AND WHICH EXPRESSIONS EVALUATE TO THE VALUE TARGET.
// MEMOIZATION HELPS TO ELIMINATE THE REPETITION OF THE ALREADY EXPLORED PATH. FOR MEMOIZATION, WE WILL BE USING A 2D ARRAY, WHERE THE ROW REPRESENTS THE
// DEPTH OF THE RECURSIVE TREE AND THE COLUMN REPRESENTS THE SUM VALUE AT THAT DEPTH. 

class Solution {
    int total = 0;
public:
    // EXPLORING ALL POSSIBLE EXPRESSIONS THAT CAN BE YIELDED FROM THE GIVEN ARRAY USING RECURSION WITH MEMOIZATION.
    int calculate(vector<int>& nums,int i,int s,int target,int** mem)
    {
        if(i == nums.size())
        {
            if(s == target)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        
        if(mem[i][s+total] != INT_MIN)
        {
            return mem[i][s+total];
        }
        else
        {
            int l = calculate(nums,i+1,s+nums[i],target,mem);
            int r = calculate(nums,i+1,s-nums[i],target,mem);
            
            mem[i][s+total] = l+r;
            
            return mem[i][s+total];
        }
    }
    
    int findTargetSumWays(vector<int>& nums, int target) 
    {
        int** mem = (int**)malloc(sizeof(int*)*nums.size());
        
        for(int i=0;i<nums.size();i++)
        {
            total += nums[i];
        }
        
        for(int i=0;i<nums.size();i++)
        {
            mem[i] = (int*)malloc(sizeof(int)*((2*total)+1));
            
            for(int j=0;j<((2*total)+1);j++)
            {
                mem[i][j] = INT_MIN;
            }
        }
        
        return calculate(nums,0,0,target,mem);
    }
};

// TIME COMPLEXITY : O(T*N)
// SPACE COMPLEXITY : O(T*N)
