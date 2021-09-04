// THE PROBLEM STATEMENT IS TO FIND THE MINIZED MAXIMUM PAIR SUM OF THE GIVEN ARRAY. I.E. WE WILL BE GIVEN AN EVEN INDEXED ARRAY, ARR = [1,3,2,5,4,4]
// NOW, WE HAVE TO FORM PAIRS IN SUCH A WAY THAT THE MAXIMUM OF THE PAIRS SUM IS MINIMIZED. (1,5), (2,3), and (4,4), HERE THE WE HAVE TO RETURN 8 AS THE ANSWER.

// MY APPROACH IS TO SORT THE GIVEN ARRAY USING QUICKSORT METHOD, THE USE THE TWO POINTER METHOD TO PINPOINT THE MAXIMUM SUM PAIRS.
// REGARDING, THE PAIRING POINT OF VIEW, INORDER TO RETRIEVE MINIMUM PAIR SUMS, WE HAVE TO PAIR THE LARGEST ONE OF THE ARRAY WITH THE SMALLEST ONE OF THE ARRAY,
// AND SO ON.

class Solution {
    
    public static int partition(int[] nums,int low,int high)
    {
        int ind = low;
        int pivot = nums[high];
            
        for(int i=low;i<=high;i++)
        {
            if(nums[i] <= pivot)
            {
                int temp = nums[ind];
                nums[ind] = nums[i];
                nums[i] = temp;
                ind += 1;
            }
        }
        
        return ind-1;
    }
    
    // FUNCTION TO APPLY QUICK SORT 
    public static void quickSort(int[] nums,int low,int high)
    {
        if(low < high)
        {
            int p = partition(nums,low,high);
            
            quickSort(nums,low,p-1);
            quickSort(nums,p+1,high);
        }
    }

    public int minPairSum(int[] nums) 
    {
        quickSort(nums,0,nums.length-1);
        
        int left = 0,right = nums.length-1,max = 0;
        
        // TRAVERSING USING THE TWO POINTER APPROACH.
        while(left < right)
        {
            if(max < (nums[left]+nums[right]))
            {
                max = nums[left]+nums[right];
            }
            left += 1;
            right -= 1;
        }
        
        return max;
    }
}

// TIME COMPLEXITY : O(N*LOG N)
// SPACE COMPLEXITY : O(1)
