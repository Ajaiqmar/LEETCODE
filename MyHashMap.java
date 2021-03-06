// THE PROBLEM STATEMNET IS TO IMPLEMENT HASHMAP WITHOUT USING THE BUILT-IN HASHMAP FUNCTION.
// SINCE THE KEY AND VALUE ARE IN INTEGER FORMAT, MY APPROACH IS TO INITIALISE AN ARRAY TO STORE THE VALUES IN THE ARRAY USING THE KEY.

class MyHashMap {
    int HashMap[];
    
    // INITIALISNG THE HASHMAP.
    public MyHashMap() {
        HashMap = new int[1000001];
    }
    
    // INSERTING THE VALUE INTO THE HASHMAP.
    public void put(int key, int value) {
        if(value == 0)
        {
            HashMap[key] = -1;
        }
        else
        {
            HashMap[key] = value;
        }
    }
    
    // GETTING THE VALUE FROM THE HASHMAP.
    public int get(int key) {
        if(HashMap[key] == 0)
        {
            return -1;
        }
        else if(HashMap[key] == -1)
        {
            return 0;
        }
        
        return HashMap[key];
    }
    
    // REMOVING THE VALUE FROM THE HASHMAP.
    public void remove(int key) {
        HashMap[key] = 0;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
