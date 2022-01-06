// THE PROBLEM STATEMENT IS TO RETURN WHETHER IT IS POSSIBLE PICK UP AND DROP OFF ALL PASSENGERS FOR ALL THE GIVEN TRIPS, WHEN THW CAPACITY OF THE CAR
// AND A TRIPS ARRAY THAT CONTAINS THE NUMBER OF PASSENGERS, FROM AND TO IN EACH INDEX.

// MY APPROACH IS TO MAP THE FROM AND TO VALUES IN A HASH MAP WHERE FROM INDEX WILL CONTAIN NUMBER OF PASSENGERS AND TO INDEX WILL CONTAIN THE NEGATION OF THE
// THE NUMBER OF PASSENGERS VALUE. THEN TRAVERSE THE HASHTABLE, AND ADD THE VALUES OF THE HASHTABLE TO PASSENGERS VARIABLE, AT SOME POINT
// IF THE NUMBER OF PASSENGERS EXTENDS BEYOND THE GIVEN CAPACITY RETURN FALSE. FINALLY RETURN TRUE, IF IT DIDN'T EXTEND BEYOND THE CAPACITY AT ANY POINT.

class Solution 
{
    public boolean carPooling(int[][] trips, int capacity) 
    {
        // INITIALISING THE HASHTABLE.
        int[] distance = new int[1001];
        int passengers = 0;
        
        // TRAVERSING THE TRIPS ARRAY.
        for(int i=0;i<trips.length;i++)
        {
            distance[trips[i][1]] += trips[i][0];
            distance[trips[i][2]] += -trips[i][0];
        }
        
        for(int i=0;i<=1000;i++)
        {
            passengers += distance[i];
            
            if(passengers > capacity)
            {
                return false;
            }
        }
        
        return true;
    }
}

// TIME COMPLEXIY : O(N) WHERE N IS THE LENGTH OF THE TRIPS ARRAY.
// SPACE COMPLEXITY : O(M) WHERE M DEPENDS UPON THE CONSTRAINT OF FROM AND TO VALUE.
