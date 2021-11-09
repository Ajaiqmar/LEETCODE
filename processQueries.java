// THE PROBLEM STATEMENT IS TO RETURN AN ARRAY CONTAINING THE POSITION'S OF EACH VALUE IN THE QUERIES ARRAY IN THE FORMED PERMUTATION.
// THE PERMUTATION SHOULD CONTAIN FROM 1 TO M, P = [1,2,3,..M] AND THEIR INDEX IS THE POSITION OF EACH VALUE. AFTER PINPOINTING THE INDEX AND 
// ASSIGNING THE VALUE TO THE ANSWER ARRAY, MOVE THAT VALUE IN THE PERMUTATION TO INDEX 0. REPEAT THIS PROCESS FOR ALL THE VALUES IN THE QUERIES ARRAY.

// MY APPROACH IS TO STORE ALL THE PERMUTATION'S VALUE AND THEIR INDICES AS KEY, VALUE PAIR IN A HASHMAP. THIS REDUCES THE TIME FOR LOOKING UP EACH VALUES
// INDICES, NOW TRAVERSE THE QUERIES ARRAY, FIND THE INDEX OF THE CURRENT VALUE FROM THE HASHMAP, THEN TRAVERSE THE HASHMAP AND INCREMENT THE
// VALUE OF INDICES WHICH ARE LESS THAN THE CURRENT ELEMENT'S INDEX. FINALLY, INITIALISE THE CURRENT ELEMENT'S INDEX AS 0. FINALLY, RETURN THE 
// ANS ARRAY.

class Solution 
{
    public int[] processQueries(int[] queries, int m) 
    {
        // INITIALISNG THE HASHMAP
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        int[] ans = new int[queries.length];
        int ind = 0;
        
        for(int i=1;i<=m;i++)
        {
            hashmap.put(i,i-1);
        }
        
        // TRAVERSING THE QUERIES ARRAY.
        for(int i=0;i<queries.length;i++)
        {
            ans[ind] = hashmap.get(queries[i]);
            ind += 1;
            
            int v = hashmap.get(queries[i]);
            
            for(int j=1;j<=m;j++)
            {
                int temp = hashmap.get(j);
                if(temp < v)
                {
                    hashmap.put(j,temp+1);
                }
            }
            
            hashmap.put(queries[i],0);
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N)
