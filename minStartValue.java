// THE PROBLEM STATEMENT IS TO FIND THE MINIMUM START VALUE, SUCH THAT THE STEP BY STEP SUM VALUE IS ALWAYS A POSITIVE INTEGER (N > 0).
// I.E. IF THE GIVEN ARRAY IS [-3,2,-3,4,2], THEN THE MINIMUM START VALUE IS 5 BECAUSE WHEN YOU LOOK AT THE STEP BY STEP SUM,
// START_VALUE = 5
// [5+(-3),2,-3,4,2]
// [2,2+2.-3,4,2]
// [2,4,4+(-3),4,2]
// [2,4,1,1+4,2]
// [2,4,1,5,5+2]
// [2,4,1,5,7]
// WHEN YOU LOOK AT THE STEP BY STEP SUM, THE VALUES ARE ALL POSITIVE INTEGERS. IF YOU TAKE THE START VALUE AS 4, YOU WILL GET [1,3,0,4,6], IT
// DOESN'T CONTAIN ALL POSITIVE INTEGERS BECAUSE THERE IS A ZERO AT INDEX 2. HENCE, 5 IS THE START VALUE.

// MY APPROACH IS TO TRAVERSE THE ARRAY AND FIND THE PREFIX SUM FOR ALL THE INDEX, FOR INDEX 0, THE PREVIOUS VALUE IS TAKEN AS ZERO,
// NOW WHEN THE PREFIX SUM IS LESS THAN 1 FOR ANY INDEX, WE WILL REPLACE THE VALUE AS 1 AND ADD THE ABSOLUTE DIFFERENCE TO ANS VARIABLE.
// FINALLY RETURN THE ANS VARIABLE.

class Solution {
    public int minStartValue(int[] nums) 
    {
        int ans = 0;
        
        // FINDING THE PREFIX SUM FOR EACH INDEX.
        for(int i=0;i<nums.length;i++)
        {
            if(i != 0)
            {
                nums[i] = nums[i]+nums[i-1];
            }
            
            if(nums[i] < 1)
            {
                ans += (1-nums[i]);
                nums[i] = 1;
            }
        }
        
        if(ans == 0)
        {
            return 1;
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
