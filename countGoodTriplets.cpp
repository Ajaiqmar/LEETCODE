// THE PROBLEM STATEMENT IS TO RETURN COUNT OF ALL GOOD TRIPLETS.
// A TRIPLET (A,B,C) IS CALLED GOOD IF (A-B) <= X AND (B-C) <= Y AND (C-A) <= Z.

// MY APPROACH IS TO APPLY THE BRUT FORCE APPROACH SINCE THE CONSTRAINTS WERE PRETTY SMALL. THE BRUT FORCE APPROACH IS TO GO THROUGH EVERY COMBINATIONS
// OF LENGTH 3 USING THE FOR LOOP AND CHECK IF IT IS A GOOD TRIPLET.

class Solution {
public:
    int countGoodTriplets(vector<int>& arr, int a, int b, int c) {
        int countGT = 0;
        
        // CHECKING FOR GOOD TRIPLETS.
        for(int i=0;i<arr.size();i++)
        {
            for(int j=i+1;j<arr.size();j++)
            {
                for(int k=j+1;k<arr.size();k++)
                {
                    int x = abs(arr[i]-arr[j]),y = abs(arr[j]-arr[k]),z = abs(arr[k]-arr[i]);
                    
                    if(x <= a && y <= b && z <= c)
                    {
                        countGT++;
                    }
                }
            }
        }
        
        return countGT;
    }
};

// TIME COMPLEXITY : O(N*N*N)
// SPACE COMPLEXITY : O(1)
