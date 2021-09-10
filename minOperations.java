// THE PROBLEM STATEMENT IS TO RETURN MINIMUM NUMBER OF OPERATIONS TO MAOVE ALL THE BALLS TO EACH BOX. IN THE GIVEN BINARY STRING 1 REPRESENTS THERE EXISTS ONE BALL 
// INSIDE THAT BOX AND 0 REPRESENTS THERE IS NO BALL INSIDE THE BOX. WE HAVE TO RETURN THE ARRAY WHICH CONTAINS MINIMUM NUMBER OF OPERATIONS
// REQUIRED TO MOVE ALL THE BALLS TO EACH BOX. IN A SINGLE OPERATION, WE COULD MOVE THE BALL FROM ONE BOX TO THE ITS ADJACENT BOX.

// MY APPROACH IS TO TRAVERSE THE STRING FROM THE LEFT AND THEN RIGHT,AT EACH INDEX ADD THE VALUE OF DISTANCE TO THE ANS ARRAY, THEN CHECK IF
// THE CURRENT INDEX CHARACTER IS '1', IF IT INCREMENT THE VALUE OF NOOFONES, THEN ADD THE VALUE OF NOOFONES TO THE DISTANCE. 

class Solution 
{
    public int[] minOperations(String boxes) 
    {
        int[] ans = new int[boxes.length()];
        int noOfOnes = 0,distance = 0;
        
        // TRAVERSING THE STRING FROM THE LEFT TO RIGHT.
        for(int i=0;i<boxes.length();i++)
        {
            ans[i] += distance;
            if(boxes.charAt(i) == '1')
            {
                noOfOnes += 1;
            }
            distance += noOfOnes;
        }
        
        noOfOnes = 0;
        distance = 0;
        
        // TRAVERSING THE STRING FROM THE RIGHT TO LEFT.
        for(int i=boxes.length()-1;i>=0;i--)
        {
            ans[i] += distance;
            if(boxes.charAt(i) == '1')
            {
                noOfOnes += 1;
            }
            distance += noOfOnes;
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
