// THE PROBLEM STATEMENT IS TO RETURN RESULT A BOOLEAN ARRAY WHICH SAYS THE WHETHER THE KID AT THE I-TH POSITION WILL HAVE 
// MAXIMUM CANDY IF HE GETS ALL THE EXTRA CANDY.

// MY APPROACH IS TO FIRST FIND THE MAXIMUM CANDY OF THE GIVEN ARRAY, THEN TRAVERSE THE ARRAY AGAIN AND GIVE THE EXTRA CANDIES TO THE I-TH KID
// NOW CHECK IF IT IS GREATER THAN MAXIMUM CANDY. IF IT IS APPEND TRUE TO THE RESULT TABLE ELSE APPEND FALSE TO THE RESULT TABLE.

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        int maxCandies = 0;
        
        // TRAVERSING THE ARRAY ONCE TO FIND THE MAXIMUM CANDY.
        for(int i=0;i<candies.length;i++)
        {
            if(candies[i] > maxCandies)
            {
                maxCandies = candies[i];
            }
        }
        
        // TRAVERSING ONCE AGAIN TO CHECK IF THE I-TH KID HAS MAXIMUM CANDY, IF HE GETS ALL THE EXTRA CANDY.
        for(int i=0;i<candies.length;i++)
        {
            if((candies[i]+extraCandies) >= maxCandies)
            {
                result.add(true);
            }
            else
            {
                result.add(false);
            }
        }
        
        return result;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
