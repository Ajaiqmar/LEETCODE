// THE PROBLEM STATEMENT IS TO RETURN WHETHER WE COULD REACH THE VALUE 0 IN THE GIVEN ARRAY BY CARRYING OUT THE FOLLOWING OPERATIONS,
// WE START FROM THE GIVEN INDEX THEN WE COULD EITHER MOVE TO CURRENT INDEX PLUS/MINUS THE CURRENT INDEX VALUE IN THE GIVEN ARRAY. NOTE THAT WE CAN'T
// MOVE OUT OF THE ARRAY.

// MY APPROACH IS TO DO A DEPTH FIRST SEARCH TRAVERSAL OF THE GIVEN ARRAY FROM THE GIVEN START INDEX, WE WILL ALSO KEEP NOTE OF THE VISITED
// INDICES TO MAKE THE GIVEN ARRAY NON-CYCLIC. SO, WHEN WE FIND ZERO IN THE ARRAY WE WILL RETURN TRUE, ELSE FALSE.

class Solution 
{
    // RECURSIVE FUNCTION TO DO A DFS TRAVERSAL OF THE GIVEN ARRAY.
    public boolean checkPossibilities(int[] arr,int ind,Boolean[] visited)
    {
        if(ind >= 0 && ind < arr.length && visited[ind] == null)
        {
            if(arr[ind] == 0)
            {
                return true;
            }
            
            visited[ind] = true;
            return checkPossibilities(arr,ind-arr[ind],visited) || checkPossibilities(arr,ind+arr[ind],visited);
        }
        
        return false;
    }
    
    public boolean canReach(int[] arr, int start) 
    {
        Boolean[] visited = new Boolean[arr.length];
        return checkPossibilities(arr,start,visited);
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF ELEMENTS IN THE ARRAY.
// SPACE COMPLEXITY : O(N)
