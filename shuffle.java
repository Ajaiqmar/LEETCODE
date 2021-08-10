// THE PROBLEM STATEMENT IS TO SHUFFLE THE GIVEN ARRAY OF LENGTH 2N. THE GIVEN ARRAY IS IN THE FORM OF [x1,x2,...,xn,y1,y2,..,yn] AND THE SHUFFLED
// ARRAY IS IN THE FORM [x1,y1,x2,y2,...,xn,yn].

// MY APPROACH IS TO USE SOME EXTRA SPACE OF LENGTH 2N, STORE THE INDEX VALUE 0 AND N IN J AND K VARIABLES, THEN TRAVERSE THE ANSWER ARRAY, IF THE
// INDEX IS EVEN STRORE VALUE AT THE J-TH INDEX AND INCREMENT THE J VALUE, ELSE IF IT IS ODD STORE THE VALUE AT THE K-TH INDEX AND INCREMENT THE K VALUE.

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int j = 0,k = n;
        
        // TRAVERSE THE ANSWER TO STORE THE SHUFFLED VALUES.
        for(int i=0;i<nums.length;i++)
        {
            if(i%2 == 0)
            {
                ans[i] = nums[j];
                j += 1;
            }
            else
            {
                ans[i] = nums[k];
                k += 1;
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
