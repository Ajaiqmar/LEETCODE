// THE PRBLEM STATEMENT IS TO IMPLEMENT THE RECENT COUNTER CLASS. THE PING FUNCTION ADDS A NEW REQUEST AT TIME T IN MILLISECONDS AND THEN RETURNS
// THE NUMBER OF REQUESTS THAT HAPPEND IN THE PAST 3000 MILLISECONDS.

// APPROACH 1 IS TO STORE THE PINGS IN THE ARRAY LIST AND IN EACH FUNCTION CALL TRAVERSE THE ARRAY LIST AND CHECK FOR PINGS WHICH ARE IN RANGE OF [T-3000,T].

class RecentCounter 
{
    ArrayList<Integer> pings;
    
    public RecentCounter() 
    {
        pings = new ArrayList<Integer>();
    }
    
    public int ping(int t) 
    {
        int noOfRequests = 0;
        pings.add(t);
        
        // TRAVERSING THE ARRAY TO CHECK FOR PINGS IN RANGE OF [T-3000,T]
        for(int i=0;i<pings.size();i++)
        {
            int p = pings.get(i);
            if(p <= t && p >= (t-3000))
            {
                noOfRequests += 1;
            }
        }
        
        return noOfRequests;
    }
}

// TIME COMPLEXITY : O(T*N) WHERE T IS THE NUMBER OF FUNCTION CALLS.
// SPACE COMEPLEXITY : O(N)

// APPROACH 2 IS USED WHEN THE PINGS ARE IN ASCENDING ORDER OF THEIR FUNCTION CALL. IN THIS CASE, WWE NEED TO TRAVERSE THE ARRAY IN REVERSE AND CHECK IF ANY
// PINGS ARE IN THE RANGE OF [T-3000,T]

class RecentCounter 
{
    ArrayList<Integer> pings;
    
    public RecentCounter() 
    {
        pings = new ArrayList<Integer>();
    }
    
    public int ping(int t) 
    {
        int noOfRequests = 0;
        pings.add(t);
        
        // TRAVERSING THE ARRAY TO CHECK FOR PINGS IN RANGE OF [T-3000,T]
        for(int i=(pings.size()-1);i>=0;i--)
        {
            if(pings.get(i) < (t-3000))
            {
                break;
            }
            noOfRequests += 1;
        }
        
        return noOfRequests;
    }
}

// TIME COMPLEXITY : O(T*N) WHERE T IS THE NUMBER OF FUNCTION CALLS AND N IS THE NUMBER OF ELEMENTS IN RANGE.
// SPACE COMEPLEXITY : O(N)

// APPROACH 3 IS ALSO USED WHEN THE PINGS ARE IN ASCENDING ORDER OF THEIR FUNCTION CALL. IN THIS CASE, I IMPLIED THE SLIDING WINDOW TECHNIQUE USING THE LINKEDLIST OR 
// STACK DATA STRUCTURE. WHENEVER THE PING FUNCTION IS CALLED THE VARIABLE T IS ADDED INTO THE LINKED LIST AND THE ELEMENTS WHICH ARE NOT IN
// RANGE OF [T-3000,T] IS REMOVED FROM THE HEAD OF THE LINKED LIST.

class RecentCounter 
{
    LinkedList<Integer> pings;
    
    public RecentCounter() 
    {
        pings = new LinkedList<Integer>();
    }
    
    public int ping(int t) 
    {
        // INSERTING THE PINGS INSIDE THE LINKED LIST.
        pings.add(t);
        
        // REDUCING THE SLIDING WINDOW LENGTH UNTIL ALL THE ELEMENTS IN THE LINKED LIST ARE IN THE RANGE OF [T-3000,T]
        while(pings.peek() < (t-3000))
        {
            pings.poll();
        }
        
        return pings.size();
    }
}

// TIME COMPLEXITY : O(T*N) WHERE T IS THE NUMBER OF FUNCTION CALLS AND N IS THE NUMBER OF ELEMENTS OUTSIDE THE RANGE.
// SPACE COMEPLEXITY : O(N)
