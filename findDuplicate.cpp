// PROBLEM DESCRIPTION : https://leetcode.com/problems/find-the-duplicate-number/

// EVEN THOUGH THE SPECIFICATIONS ARE TO SOLVE THE PROBLEM WITHOUT MODIFYING THE ARRAY, I COULDN'T FULLFILL THIS SPECIFICATION. BUT I DID READ THE 
// SOLUTION EXPLANATION WHERE THEY HAVE USED A UNIQUEB WAY TO IDENTIFY THE DUPLICATE USING THE METHOD TO FIND OUT THE NODE WHERE THE CYCLE BEGINS IN A LINKED LIST.

// MY APPROACH IS, SINCE ALL THE VALUES ARE INCLUSIVE OF [1,N] WE CAN USE NEGATIVE MARKING TO IDENTIFY THE DUPLICATE VALUE, BASICALLY WE TRAVERSE THE ARRAY
// AND TAKE THE CURRENT VALUE - 1 AS INDEX AND JUST NEGATE THAT VALUE AT THAT INDEX. IF THE VALUE ISN'T ALREADY NEGATED, IF IT IS THEN RETURN THE CURRENT VALUE.
// THIS FULLFILLS THE LINEAR TIME COMPLEXITY AND CONSTANT SPACE CONSTRAINT.

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int n = nums.size();
        
        // TRAVERSING THE ARRAY
        for(int i=0;i<n;i++)
        {
            if(nums[abs(nums[i])-1] > 0)
            {
                nums[abs(nums[i])-1] = -nums[abs(nums[i])-1];
            }
            else
            {
                return abs(nums[i]);
            }
        }
        
        return 0;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
