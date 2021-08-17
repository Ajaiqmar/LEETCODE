// THE PROBLEM STATEMENT IS TO CHECK IF WE CAN GET AN ARITHMETIC PROGRESSION ARRAY WHEN WE REARRANGE THE INTEGERS IN THE GIVEN ARRAY.

// MY APPROACH IS TO FIRST FIND THE DIFFERENCE IN THE ARITHMETIC PROGRESSION. SO INORDER TO FIND THAT WE MUST FIND EITHER THE MINIMUM AND SECOND MINIMUM OR MAXIMUM AND
// SECOND MAXIMUM, WHICH WILL YIELD THE DIFFERENCE. WHILE FINDING THE DIFFERENCE, INSERT ALL THE INTEGERS IN THE ARRAY IN THE HASHMAP. SO NOW WE HAVE TO INCREMENT OR DECREMENT
// FROM THE MINIMUM OR MAXIMUM OF ARRAY WITH THE DIFFERENCE AND CHECK IF THE VALUE IS PRESENT IN THE HASHMAP.

class Solution 
{
    public boolean canMakeArithmeticProgression(int[] arr) 
    {
        int min = Integer.MAX_VALUE,smin = Integer.MAX_VALUE;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        
        // TRAVERSE THE ARRAY TO FIND THE MINIMUM AND SECOND MINIMUM. ALSO INSERT THE INTEGERS ONTO THE HASHMAP.
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] < min)
            {
                smin = min;
                min = arr[i];
            }
            else if(arr[i] < smin)
            {
                smin = arr[i];
            }
            
            if(hm.get(arr[i]) == null)
            {
                hm.put(arr[i],1);
            }
            else
            {
                hm.put(arr[i],hm.get(arr[i])+1);
            }
        }
        
        int d = smin - min,s = min;
        
        // NOW CHECK IF THE VALUES WITH ARITHMETIC DIFFERENCE IS PRESENT IN THE ARRAY.
        for(int i=0;i<arr.length;i++)
        {
            if(hm.get(s) == null || hm.get(s) == 0)
            {
                return false;
            }
            hm.put(s,hm.get(s)-1);
            s = s+d;
        }
        
        return true;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMEPLEXITY : O(N)
