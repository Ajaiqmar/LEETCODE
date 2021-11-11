// THE PROBLEM STATEMENT IS TO RETURN MINIMUM NUMBER OF OPERATIONS IT TAKES TO MAKE THE ARRAY EQUAL. THE ARRAY TO BE CONSTRUCTED SHOULD BE OF LENGTH N
// AND EACH VALUE IN EACH INDEX IS EQUAL TO (I*2)+1 WHERE I IS THE INDEX. IN A SINGLE OPERATION, WE CAN TAKE ANY TWO VALUES IN THE ARRAY AND DECREMENT
// ONE OF THE INDEX VALUES BY ONE ALSO INCREMENT ONE OF THE INDEX VALUES BY ONE(I.E. ARR[X] += 1 AND ARR[X] -= 1 WHERE 0 <= X,Y < N).

// MY APPROACH IS TO TAKE THE MIDDLE VALUE(N) OF THE CONSTRUCTED ARRAY AND FIND COST IT TAKES FOR THE FIRST (N/2) ELEMENTS TO REACH THAT VALUE.
// BECAUSE, IN A SINGLE OPERATION WE CAN INCREMENT A VALUE AND DECREMENT ANOTHER INDEX VALUE, SO WE COULD CHOOSE INDEX I AND INCREMENT ITS VALUE AT
// THE SAME TIME, WE CAN DECREMENT THE VALUE OF INDEX (N-(I+1)).

class Solution {
    public int minOperations(int n) 
    {
        int ans = 0;
        
        // TRAVERSING THE RANGE 0 TO N/2 TO FIND THE MINIMUM COST.
        for(int i=0;i<n/2;i++)
        {
            int v = (2*i)+1;
            ans += Math.abs(v-n);
        }
  
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)


// THERE IS AN EVEN MORE EFFECTIVE APPROACH WHICH CAN CARRY OUT THE SAME FUNCTION USING MATHEMATICS.
// IF YOU LOOK AT THE VALUE OF N AND THE MINIMUM COST,
// N = 1 , MC = 0
// N = 2 , MC = 1
// N = 3 , MC = 2
// N = 4 , MC = 4
// N = 5 , MC = 6
// N = 6 , MC = 9

// IF YOU LOOK CLOSELY, THE LOGIC IS (N*N)/4.
// THIS IS EFFECTIVE BECAUSE IT CARRIES OUT THE D=SAME FUNCTION IN O(1) TIME COMPLEXITY.
