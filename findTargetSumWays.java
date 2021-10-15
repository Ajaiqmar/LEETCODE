// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF EXPRESSION THAT EVALUATE TO THE VALUE TARGET, WHEN THE OPERANDS ARE GIVEN IN THE FORM OF ARRAY AND OPERATORS TO BE
// USED ARE '+' AND '-'.

// MY APPROACH IS A BRUTE FORCE APPROACH, DOING A RECURSIVE CALL FOR EVERY POSSIBILITY OPERAND AND OPERATOR THAT CAN BE FORMED AND CHECKING IF THE FINAL VALUE IS 
// EQUAL TO TARGET. BUT THE TIME COMPLEXITY IS A PROBLEM HERE. SINCE THERE ARE TWO OPERATORS EACH OPERAND CAN BE EXPRESSED IN TWO WAYS.
// SO, THERE 2^N POSSIBILITIES.

class Solution 
{
    // RECURSIVE FUNCTION TO ESTABLISH EVERY POSSIBLE EXPRESSION.
    public void findExpressions(int[] nums,int index,int target,int value,int[] ans)
    {
        if(index == nums.length)
        {
            if(value == target)
            {
                ans[0] += 1;
            }
        }
        else
        {
            findExpressions(nums,index+1,target,value+nums[index],ans);
            findExpressions(nums,index+1,target,value-nums[index],ans);
        }
    }
    public int findTargetSumWays(int[] nums, int target) 
    {
        int[] ans = new int[1];
        findExpressions(nums,0,target,0,ans);
        
        return ans[0];
    }
}

// TIME COMPLEXITY : O(2^N)
// SPACE COMPLEXITY : O(N) WHERE N IS THE NUMBER OF ELEMENTS IN THE ARRAY. 
