// THE PROBLEM STATEMENT IS TO RETURN THE GIVEN ARRAY IN SUCH A WAY THAT ALL THE EVEN INTEGERS ARE PRESENT IN THE EVEN INDEX AND ALL THE ODD INTEGERS
// ARE PRESENT IN THE ODD INDEX.

// THE FOLLOW UP QUESTION WAS TO DO IT IN PLACE, IN OTHER WORDS THEY ASKED US TO SLOVE THE PROBLEM IN O(1) EXTRA SPACE.

// MY APPROACH IS TO TRAVERSE THE ARRAYB USING TWO POINTERS, THE FIRST POINTER WILL TRAVERSE ALL THE EVEN INDICES AND THE ODD POINTER WILL
// TRAVERSE ALL THE ODD INDICES. WHILE TRAVERSING FIND IF THERE IS AN ODD ELEMENT IN THE EVEN INDEX AND AN EVEN ELEMENT IN ODD INDEX, IF SUCH ELEMENTS 
// EXIST, SWAP THEM BOTH.

class Solution 
{
    public:
        vector<int> sortArrayByParityII(vector<int>& nums) 
        {
            int n = nums.size();
            int left,right;
            
            // ASSIGNING THE POINTER VALUES.
            if(n%2 == 0)
            {
                left = 0;
                right = n-1;
            }
            else
            {
                left = 0;
                right = n-2;
            }
            
            // TRAVERSING THE GIVEN ARRAY.
            while(left < n && right >= 0)
            {
                int flag1 = 1,flag2 = 1;
                
                if(nums[left]%2 == 0)
                {
                    left += 2;
                    flag1 = 0;
                }
                
                if(nums[right]%2 != 0)
                {
                    right -= 2;
                    flag2 = 0;
                }
                
                if(flag1 && flag2)
                {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left += 2;
                    right -= 2;
                }
            }
            
            return nums;
        }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
