// THE PROBLEM STATEMENT IS TO RETURN AN ARRAY IN WHICH AT EACH INDEX CONTAINS THE ANSWER OF THE EACH QUERY. I.E. LENGTH OF THE ARRAY TO BE RETURNED = LENGTH
// OF THE QUERY ARRAY. IN THE QUERY ARRAY, EACH INDEX CONTAINS THE CENTRE COORDINATES AND THE RADIUS OF A CIRCLE TO BE DRAWN AROUND THE CIRCLE.
// FOR EACH QUERY, WE HAVE TO FIND THE NUMBER OF POINTS IN THE PONTS ARRAY THAT IS WITHIN THE CIRCLE. ADDITIONALLY, FOR EACH QUERY WE HAVE TO TAKE ONLY O(N) TIME
// COMPLEXITY.

// MY APPROACH IS FOR EACH QUERY, TRAVERSE THE GIVEN POINTS ARRAY FIND THE DISTANCE OF CURRENT POINTS FROM THE CENTER AND APPLY THE PYTHAGORAS THEOREM. IF THE
// THIRD SIDE IS LESS THAN THE OR EQUAL TO THE RADIUS THEN INCREMENT THE PONITS COUNT BY ONE, AFTER GOING THROUGH ALL THE POINTS
// APPEND IT TO THE ARRAY. FINALLY, RETURN THE ARRAY.

class Solution 
{
    public int[] countPoints(int[][] points, int[][] queries) 
    {
        // DECLARING THE ARRAY TO BE RETURNED
        int[] ans = new int[queries.length];
        
        // TRAVERSING THE QUERIES ARRAY.
        for(int i=0;i<queries.length;i++)
        {
            int p = 0,r = queries[i][2];
            
            for(int j=0;j<points.length;j++)
            {
                int dx = Math.abs(queries[i][0]-points[j][0]),dy=Math.abs(queries[i][1]-points[j][1]);
                int c = (int)Math.ceil(Math.sqrt((dx*dx)+(dy*dy)));
                
                if(c <= r)
                {
                    p += 1;
                }
            }
            
            ans[i] = p;
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(M*N) WHERE M IS THE LENGTH OF THE QUERIES ARRAY AND N IS THE LENGTH OF THE POINTS ARRAY.
// SPACE COMPLEXITY : O(M)
