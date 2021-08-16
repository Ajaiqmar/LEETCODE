// THE PROBLEM STATEMENT IS TO RETURN AN ARRAY WHICH CONTAINS THE LARGEST INTEGER IN THE ARRAY ARR WHICH IS TO RIGHT OF THE INDEX. THE LAST INDEX VALUE WILL ALWAYS 
// BE -1.

// MY APPROACH IS TO TRAVERSE THE ARRAY IN REVERSE ORDER. ALSO MAINTAIN A MAX VALUE WHOSE INITIAL VALUE IS -1 AND AT EACH INDEX ASSIGN THE ARRAY VALUE TO A TEMP THEN
// ASSIGN THE MAX VALUE TO THE ARRAY ALSO CHECK IF THE TEMP VALUE IS GREATER THAN THE MAX VALUE, IF IT IS ASSIGN TEMP VALUE TO THE MAX VALUE.

class Solution {
    public int[] replaceElements(int[] arr) 
    {
        int max = -1;
        
        // TRAVERSING THE ARRAY IN REVERSE ORDER.
        for(int i=(arr.length-1);i>=0;i--)
        {
            int temp = arr[i];
    
            arr[i] = max;
            
            if(temp > max)
            {
                max = temp;
            }
        }
        
        return arr;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
