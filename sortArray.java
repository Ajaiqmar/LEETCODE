// THE PROBLEM STATEMENT IS TO SORT THE ARRAY.

// MY APPROACH IS TO USE THE QUICK SORT ALGORITHM.

class Solution 
{
    // FUNCTION TO TAKE A PIVOT AND ARRANGE THE SUB-ARRAY IN SUCH A WAY THAT ALL THE ELEMENTS TO THE LEFT ARE SMALLER THAN PIVOT AND ALL THE ELEMENTS
    // TO THE RIGHT ARE GREATER THAN THE PIVOT.
    public static int partition(int[] nums,int low,int high)
    {
        int pivot = nums[high];
        int ind = low;
        
        for(int i=low;i<=high;i++)
        {
            if(nums[i] <= pivot)
            {
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                ind += 1;
            }
        }
        
        return ind-1;
    }
    
    // FUNCTION TO DIVIDE THE ARRAY INTO SUB-ARRAY ACCORDING TO THE CHOSEN PIVOT. 
    public static void quickSort(int[] nums,int low,int high)
    {
        if(low < high)
        {
            int p = partition(nums,low,high);
            
            quickSort(nums,low,p-1);
            quickSort(nums,p+1,high);
        }
    }
    
    public int[] sortArray(int[] nums) 
    {
        quickSort(nums,0,nums.length-1);
        
        return nums;
    }
}

// TIME COMPLEXITY : O(N * LOG N)
// SPACE COMPLEXITY : O(N)
