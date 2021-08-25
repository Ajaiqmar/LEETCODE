// THE PROBLEM STATEMENT IS TO SORT THE ARRAY IN SUCH A WAY THAT ALL THE EVEN INTEGERS ARE IN FRONT OF THE ODD INTEGERS.

// MY APPROACH IS TO JUST TRAVERSE THE ARRAY AND WHENEVER I FIND AN EVEN INTEGERS I WOULD SWAP THEM WITH THE ELEMENT IN THE SLDING INDEX AND 
// INCREMENT THE SLIDING INDEX. IND VARIABLE IS THE SLIDING INDEX HERE.

class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int ind = 0;
        
        // TRAVERSING THE ARRAY.
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]%2 == 0)
            {
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                ind += 1;
            }
        }
        
        return nums;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
