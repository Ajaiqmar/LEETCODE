class MyHashMap {
    int HashMap[];
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        HashMap = new int[1000001];
    }
    
    /** value will always be non-negative. */
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
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
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
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        HashMap[key] = 0;
    }
}
