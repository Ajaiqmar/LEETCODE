// THE PROBLEM STATEMENT IS TO DESIGN AN ORDERED STREAM. THERE ARE N STREAM VALUES AND EACH STREAM VALUES HAVE UNIQUE ID KEY. EACH STREAM VALUE
// IS INSERTED ONTO THE STREAM USING INSERT FUNCTION. AFTER INSERTION, THE FUNCTION SHOULD RETURN THE LARGEST POSSIBLE CONTINOUS CHUNK.

// MY APPROACH IS TO DECLARE AND INITIALISE N WHERE N IS THE NUMBER OF STREAMS, A CHUNKS ARRAY OF LENGTH N, VISITED ARRAY OF LENGTH N AND A CURRENT ID KEY.
// IN THE INSERT FUNCTION, THE IDKEY OF THE STREAM AND ITS VALUE IS GIVEN, UNLESS WE RECEIVE THE IDKEY IN SEQUENTIAL ORDER, WE HAVE TO WAIT,
// ONCE RECEIVED RETURN THE LARGEST POSSIBLE CHUNK.

class OrderedStream 
{
    String[] chunks;
    int[] visited;
    int n;
    int currentIdKey;
    
    // INITIALSING THE INSTANCE VALUES.
    public OrderedStream(int n) 
    {
        this.n = n;
        chunks = new String[n];
        visited = new int[n];
        currentIdKey = 0;
    }
    
    // INSERTING THE VALUES ONTO THE STREAM.
    public List<String> insert(int idKey, String value) 
    {
        chunks[idKey-1] = value;
        visited[idKey-1] = 1;
        
        List<String> chunk = new ArrayList<String>();
            
        while(currentIdKey < n && visited[currentIdKey] != 0)
        {
            chunk.add(chunks[currentIdKey]);
            currentIdKey += 1;
        }
        
        return chunk;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
