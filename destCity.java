// THE PROBLEM STATEMENT IS TO RETURN THE DESTINATION CITY FROM THE GIVEN PATHS ARRAY. EVERY INDEX OF THE PATHS ARRAY WILL CONTAIN TWO CITIES CITY A AND CITY B.

// MY APPROACH IS TO SIMPLY TRAVERSE THE PATHS ARRAY ONCE AND INSERT ALL THE CITY A ONTO THE HASHMAP, THEN TRAVERSE THE PATHS ARRAY
// ONCE AGAIN AND CHECK WHICH CITY B IS NOT PRESENT IN THE HASHMAP AND RETURN THAT CITY.

class Solution 
{
    public String destCity(List<List<String>> paths) 
    {
        HashMap<String,Boolean> cityA = new HashMap<String,Boolean>();
        
        // TRAVERSING THE PATHS ARRAY ONCE AND INSERTING ALL THE CITY A ONTO THE HASHMAP.
        for(int i=0;i<paths.size();i++)
        {
            cityA.put(paths.get(i).get(0),true);
        }
        
        // TRAVERSING THE PATHS ARRAY ONCE AGAIN AND CHECKING WHICH CITY B IS NOT PRESENT IN THE HASHMAP.
        for(int i=0;i<paths.size();i++)
        {
            if(cityA.get(paths.get(i).get(1)) == null)
            {
                return paths.get(i).get(1);
            }
        }
        
        return "";
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

