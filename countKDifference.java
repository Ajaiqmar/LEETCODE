// THE PROBLEM STATEMENT IS TO FIND THE NUMBER OF UNIQUE INDEX PAIRS WHOSE ABSOLUTE DIFFERENCE IS K. I.E |ARR[I] - ARR[J]| = K WHERE I < J.

// MY APPROACH IS TO STORE THE OCCURRENCE OF THE DIGITS IN THE NUMS ARRAY INTO AN HASHTABLE, THEN TRAVERSE THE HASHTABLE AND FIND THE DIGIT WHOSE COUNT IS
// GREATER THAN ZERO AND MULTIPLY THAT WITH THE VALUE IN CURRENT INDEX + K. THEN ADD THE PRODUCT TO THE ANS VALUE. THIS WILL YIELD THE UNIQUE
// PAIRS WHOSE ABSOLUTE DIFFERENCE IS K.

class Solution 
{
    public int countKDifference(int[] nums, int k) 
    {
        int[] hashTable = new int[101];
        int ans = 0;
        
        // STORING THE DIGITS OCCURRENCES IN THE HASHTABLE.
        for(int i=0;i<nums.length;i++)
        {
            hashTable[nums[i]]++;
        }
        
        // FINDING THE UNIQUE PAIRS WHOSE ABSOLUTE DIFFERENCE IS K.
        for(int i=1;i<101;i++)
        {
            if((i+k) < 101 && hashTable[i+k] > 0)
            {
                ans += hashTable[i]*hashTable[i+k];
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(MAX(N,CONSTRAINT))
// SPACE COMPLEXITY : O(CONSTRAINT)
