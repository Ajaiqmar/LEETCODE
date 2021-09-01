// THE PROBLEM STATEMENT IS TO RETURN THE MINIMUM TOTAL THAT CAN BE RETRIEVED FROM THE GIVEN TRIANGULAR MATRIX.
// I.E    2
//       3 4
//      6 5 7
//     4 1 8 3  
// IN THE GIVEN TRIANGULAR MATRIX THE MINIMUN TOTAL THAT CAN BE RETRIEVED IS 2+3+5+1 = 11. THERE ARE MANY PATHS TO EXPLORE.
// BUT OUR JOB IS TO CHOOSE THE EXACT PATH WHOSE SUM IS THE MINIMUM TOTAL AMONG ALL THE PATHS.

// MY APPROACH IS TO USE TH GIVEN TRIANGULAR MATRIX AND DO A BOTTOM UP TRAVERSAL, WE START FROM THE LAST-1 ROW, AND FOR EACH CELL WE ADD THE MINIMUM OF THE ELEMENTS
// IN THE NEXT ROW SAME COLUMN OR NEXT ROW NEXT COLUMN. THIS WILL YIELD SMALLEST SUM AS THE TOP VALUE. 

class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        // TRAVERSING THE GIVEN TRIANGULAR MATRIX FROM BOTTOM TO UP.
        for(int i=(triangle.size()-1);i>=1;i--)
        {
            for(int j=0;j<(triangle.get(i).size()-1);j++)
            {
                triangle.get(i-1).set(j,Math.min(triangle.get(i).get(j),triangle.get(i).get(j+1))+triangle.get(i-1).get(j));
            }
        }
        
        return triangle.get(0).get(0);
    }
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)
