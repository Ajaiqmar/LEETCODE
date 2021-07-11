class MyHashSet {
    int[] hashSet;
    /** Initialize your data structure here. */
    public MyHashSet() 
    {
        hashSet = new int[1000001];
    }
    
    public void add(int key) 
    {
        if(hashSet[key] == 0)
        {
            hashSet[key] = 1;
        }
    }
    
    public void remove(int key) 
    {
        if(hashSet[key] == 1)
        {
            hashSet[key] = 0;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) 
    {
        return hashSet[key] == 1;
    }
}
