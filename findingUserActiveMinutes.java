// THE PROBLEM STATEMENT IS TO RETURN AN 1-INDEXED ARRAY OF LENGTH K IN WHICH EACH INDEX REPRESENTS THE NUMBER OF USER ACTIVE MINUTES. WE HAVE TO COMB THROUGH
// THE LOGS, FIND OUT UNIQUE USERS AND THEIR USER ACTIVE MINUTES AND INCREMENT THE CORRESPONDING INDEX IN THE ARRAY.

// MY APPROACH IS TO USE A NESTED DATA STRUCTURE COMPRISING HASHMAPS AND HASHSETS TO KEEP IN CHECK THE NUMBER OF UNIQUE USERS AND THEIR USER ACTIVE MINUTES.
// THE HASHMAP HOLDS THE USER ID AS THE KEY AND AN HASHSET AS THE VALUE PAIR, INSIDE THE HASHSET WE STORE ALL USER ACTIVE MINUTES WHILE TRAVERSING THE LOGS ARRAY.
// WE ALSO INCREMENT THE RESULTANT ARRAYS INDICES THAT CORRESPONDS TO THE CURRENT USER'S USER ACTIVE MINUTES.

class Solution 
{
    public int[] findingUsersActiveMinutes(int[][] logs, int k) 
    {
        int[] ans = new int[k];
        HashMap<Integer,HashSet<Integer>> hm = new HashMap<Integer,HashSet<Integer>>();
        
        // TRAVERSING THE LOGS ARRAY.
        for(int i=0;i<logs.length;i++)
        {
            if(hm.get(logs[i][0]) == null)
            {
                HashSet<Integer> hs = new HashSet<Integer>();
                hs.add(logs[i][1]);
                
                hm.put(logs[i][0],hs);
                ans[0] += 1;
            }
            else
            {
                HashSet<Integer> hs = hm.get(logs[i][0]);
                int prev = hs.size();
                
                hs.add(logs[i][1]);
                
                int curr = hs.size();
                
                if(prev != curr)
                {
                    ans[curr-2] -= 1;
                    ans[curr-1] += 1;
                }
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N) SICE ALL THE OPERATIONS THAT ARE APPLIED IN THE LOOPING STRUCTURE IS OF COMPLEXITY O(1).
// SPACE COMPLEXITY : O(M*L) WHERE M IS THE NUUMBER OF UNIQUE USERS AND L IS THEIR RESPECTIVE NUMBER OF USER ACTIVE MINUTES.
