// THE PROBLEM STATEMENT IS TO RETURN AN ARRAY OF THE K VALUES CORRESPONDING TO A SEQUENCE OF PANCAKE FLIPS THAT SORT THE GIVEN ARRAY.
// IN ONE PANCAKE FLIP, WE CAN CHOOSE AN INTEGER K WHERE K >= 0 AND K < ARR.LENGTH AND WE NEED TO REVERSE THE SUBSEGMENT ARR[0,1..,K]. ANY
// VALID ARRAY THAT SORTS THE ARRAY WITHIN 10*LENGTH OF THE GIVEN ARRAY IS ACCEPTED.

// MY APPROACH IS TO SORT THE ARRAY FROM RIGHT HAND SIDE, MEANING THAT I WANT START ARRANGING THE VALUES FROM HIGHEST TO LOWEST.
// FIRST WE FIND THE LARGEST VALUE AND ITS INDEX, NOW WE HAVE TO FLIP THE ARRAY UP UNTIL THAT INDEX THEN WE HAVE TO FLIP THE ARRAY
// UP UNTIL N-I TH INDEX. SIMILAR TO HOW BUBBLE SORT WORKS.

class Solution 
{
    // FUNCTION TO REVERSE THE ARRAY FROM INDEX L TO R.
    public void swap(int[] arr,int l,int r)
    {
        while(l < r)
        {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            
            l += 1;
            r -= 1;
        }
    }
    
    public List<Integer> pancakeSort(int[] arr) 
    {
        List<Integer> ans = new ArrayList<Integer>();
        int n = arr.length;
        
        // SORTING THE ARRAY
        for(int i=0;i<n;i++)
        {
            int maxValue = arr[0],maxIndex = 0;
            
            for(int j=0;j<(n-i);j++)
            {
                if(arr[j] > maxValue)
                {
                    maxValue = arr[j];
                    maxIndex = j;
                }
            }
            
            swap(arr,0,maxIndex);
            swap(arr,0,n-(i+1));
            
            ans.add(maxIndex+1);
            ans.add(n-i);
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N*2) FOR EACH VALUE IN THE ARRAY, WE DO TWO PANCAKE FLIPS.
