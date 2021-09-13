// THE PROBLEM STATEMENT IS TO FIND THE TARGET IN A MATRIX THAT HAS BEEN SORTED ROW WISE AND THE LAST ELEMENT OF EACH ROW IS LESS THAN THE FIRST ELEMENT
// OF THE NEXT ROW.

// MY APPROACH IS TO TRAVERSE THE LAST COLUMN OF THE MATRIX AND PINPOINT WHICH ROW THE TARGET VALUE COULD BE AND THEN DO A
// BINARY SEARCH FOR THE GIVEN TARGET VALUE. IF IT IS FOUND RETURN TRUE, ELSE RETURN FALSE.

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) 
    {
        int row = 0;
        int n = matrix.size(),m = matrix[0].size();
        
        // TRAVERSING THE LAST COLUMN OF THE MATRIX.
        while(row < n && matrix[row][m-1] < target)
        {
            row += 1;
        }
        
        if(row == n)
        {
            return false;
        }
        
        int low = 0,high = m-1;
        
        // DOING A BINARY SEARCH TO FIND THE VALUE.
        while(low <= high)
        {
            int mid = low+((high-low)/2);
            
            if(target == matrix[row][mid])
            {
                return true;
            }
            else if(target < matrix[row][mid])
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        
        return false;
    }
};

// TIME COMPLEXITY : O(MAX(N,LOG(M)))
// SPACE COMPLEXITY : O(1)
