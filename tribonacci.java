// THE PROBLEM STATEMENT IS TO RETURN THE N-TH VALUE OF THE TRIBONACCI SERIES. I.E T(0) = 0, T(1) = 1, T(2) = 1,.. T(N) = T(N-1)+T(N-2)+T(N-3).

// MY APPROACH IS TO USE DYNAMIC PROGRAMMING, SO IN THIS APPROACH WE WILL BE INITIALISING AN ARRAY, THEN WE WILL ASSIGN THE VALUE OF THE 0,1 AND 2 INDEX, THEN
// WE TRAVERSE FROM THE INDEX 3 TO N WHILE TRAVERSING AT EACH INDEX WE ASSIGN EACH VALUE ARR[I] AS ARR[I-1]+ARR[I-2]+ARR[I-3]. FINALLY WE RETURN THE VALUE 
// OF ARR[N]. IF THE INDEX IS EITHER 0 OR 1 OR 2, WE RETURN THEIR RESPECTIVE DEFAULT VALUES 0 OR 1 0R 1 RESPECTIVELY.

class Solution {
    public int tribonacci(int n) 
    {
        if(n == 0)
        {
            return 0;
        }
        else if(n == 1 || n == 2)
        {
            return 1;
        }
      
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        
        int ind = 3;
      
        // TRAVERSING FROM 3 TO N TO FIND THE N-TH TRIBONACCI VALUE.
        while(ind <= n)
        {
            arr[ind] = arr[ind-1]+arr[ind-2]+arr[ind-3];
            ind += 1;
        }
        
        return arr[n];
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
