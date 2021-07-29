// THE PROBLEM STATEMENT IS TO IMPLEMENT A HASHSET WITHOUT USING THE BUILT-IN HASHSET FUNCTION.
// SINCE THE VALUES ARE IN INTEGER FORMAT, MY APPROACH IS TO INITIALISE AN ARRAY AND THEN CARRY OUT THE HASHSET OPERATIONS.

class MyHashSet {
    int[] hashSet;

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
    
    public boolean contains(int key) 
    {
        return hashSet[key] == 1;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
