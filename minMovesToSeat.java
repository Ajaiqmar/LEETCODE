// THE PROBLEM STATEMENT IS TO MOVE THE STUDENTS FROM THEIR POSITION TO THE NEAREST SEAT POSITION SUCH THAT IT TAKES MINIMUM NUMBER OF MOVES TO MOVE
// ALL THE STUDENTS TO A SEAT POSITION. THE COST TO MOVE FROM CURRENT POSITION X TO THE ADJACENT POSITIONS X+1 OR X-1 IS 1.

// SINCE WE HAVE TO FIND IDLE POSITION TO EACH STUDENT, THE BRUTE FORCE APPROACH WOULD BE TO USE NESTED FOR LOOPS TO PINPOINT THE IDLE POSITION FOR
// EACH STUDENT. BUT THEN THE TIME COMPLEXITY WOULD BE O(N*N). SO MY APPROACH IS TO SORT BOTH THE SEATS ARRAY AND THE STUDENTS ARRAY THEN FIND THE SUM OF ABSOLUTE
// DIFFERENCE BETWEEN THE VALUES IN THE SAME INDEX, WHICH WILL YIELD THE MINIMUM MOVES.

// THE REASON BEING IS WHILE SORTING THEM WE ARE ARRANGING THE POSITIONS OF STUDENTS AND SEATS IN ASCENDING ORDER. SO, WHEN WE LOOK AT THE
// ARRAY THEN WE WILL MATCH THE FIRST HIGHEST POSITION OF SEATS WITH STUDENTS, WHICH CANNOT BE MATCHED WITH ANY OTHER BECAUSE IF WE TRAVEL ALONG THE
// ARRAY THE POSITIONS ARE GOINGH TO INCREASE THERBY INCREASING THE TOTAL COST. I.E. GIVEN ARRAYS ARE SEATS = [3,1,5] AND STUDENTS = [2,7,4].
// AFTER SORTING IT BECOMES, SEATS = [1,3,5] AND STUDENTS = [2,4,7], NOW IF WE LOOK AT THE FIRST INDEX, IT CAN'T BE MATCHED TO ANY OTHER OTHER THAN 2 ELSE
// THE COST WOULD INCREASE.

class Solution 
{
    // FUNCTION TO ARRANGE THE ARRAY USING THE PIVOT ELEMENT.
    static int pivot(int[] arr,int low,int high)
    {
        int ind = low;
        int p = arr[high];
        
        for(int i=low;i<=high;i++)
        {
            if(arr[i] <= p)
            {
                int temp = arr[ind];
                arr[ind] = arr[i];
                arr[i] = temp;
                ind += 1;
            }
        }
        
        return ind-1;
    }
    
    // QUICK SORT FUNCTION.
    static void quickSort(int[] arr,int low,int high)
    {
        if(low < high)
        {
            int p = pivot(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }
    
    public int minMovesToSeat(int[] seats, int[] students) 
    {
        int n = seats.length;
        quickSort(seats,0,n-1);
        quickSort(students,0,n-1);
        
        int ans = 0;
        // FINDING THE MINIMUM COST
        for(int i=0;i<n;i++)
        {
            ans += Math.abs(seats[i]-students[i]);
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N LOG N)
// SPACE COMPLEXITY : O(1)
