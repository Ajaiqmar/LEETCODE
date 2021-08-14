// THE PROBLEM STATEMENT IS TO RETURN TRUE IF THE NUMBER OF OCCURRENCES OF THE INTEGERS IN ARR IS UNIQUE ELSE RETURN FALSE.
// I.E ARR = [1,2,2,3,3,3]. IN THE GIVEN ARRAY, 1 OCCURS 1 TIME, 2 OCCURS 2 TIMES AND  OCCURS 3 TIMES. SINCE THE NUMBER OF OCCURRENCES ARE ALL UNIQUE.
// ANSWER IS TRUE.

// MY APPROACH IS TO STORE THE INTEGERS AND THEIR NUMBER OF OCCURRENCES IN A HASHTABLE, SINCE THE CONSTRAINTS ARE SMALL. AND THEN STORE THE NUMBER OF OCCURRENCES 
// AND THEIR OCCURRENCE IN A HASH TABLE. NOW CHECK IF THEY ARE ALL UNIQUE. IF IT IS THEN RETURN TRUE,ELSE RETURN FALSE.

class Solution 
{
    public boolean uniqueOccurrences(int[] arr) 
    {
        int[] occurrences = new int[2001];
        int[] uniqueOccurrences = new int[1001];
        
        // TRAVERSING THE GIVEN ARR AND STORING THEIR OCCURRENCE IN THE HASH TABLE.
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] <= 0)
            {
                arr[i] = -arr[i];
            }
            else
            {
                arr[i] = arr[i]+1000;
            }
            occurrences[arr[i]] += 1;
        }
        
        // TRAVERSING THE OCCURRENCE HASH TABLE AND STORING THEIR OCCURRENCE IN ANOTHER HASH TABLE.
        for(int i=0;i<2001;i++)
        {
            if(occurrences[i] != 0)
            {
                if(uniqueOccurrences[occurrences[i]]==1)
                {
                    return false;
                }
                else
                {
                    uniqueOccurrences[occurrences[i]]+=1;
                }
            }
                
        }
        
        return true;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE CMPLEXITY : O(N)
