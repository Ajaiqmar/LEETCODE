// THE PROBLEM STATEMENT IS TO CHECK WHETHER THE GIVEN ARRAY CONTAINS A PATTERN OF LENGTH M FOR K CONSECUTIVE TIMES.

// MY APPROACH IS TO USE MODIFIED KADANE ALGORITHM, HERE WE ARE INCREMENTING THE COUNTOFCONSECUTIVEONES WHEN THE CURRENT INDEX ELEMENT IS
// EQUAL TO INDEX+M ELEMENT, ELSE WE SET THE VALUE TO ZERO. IF THE COUNTOFCONSECUTIVEONES VALUE IS EQUAL TO (K-1)*M
// THE WE RETURN TRUE, ELSE FALSE. THE REASON IS THE LAST SET OF M ELEMENTS MAY OR MAY NOT HAVE THE SAME VALUE TO COMPARE TO IN THE INDEX+M POSITION. 

bool containsPattern(int* arr, int arrSize, int m, int k)
{
    int countOfConsecutiveOnes = 0;
    
    // TRAVERSING THE LOOP TO CHECK FOR THE CONSECUTIVE ONES.
    for(int i=0;i<(arrSize-m);i++)
    {
        if(arr[i] != arr[i+m])
        {
            countOfConsecutiveOnes = 0;
        }
        else
        {
            countOfConsecutiveOnes++;
        }
        
        if(countOfConsecutiveOnes == (k-1)*m)
        {
            return true;
        }
    }
    
    return false;
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
