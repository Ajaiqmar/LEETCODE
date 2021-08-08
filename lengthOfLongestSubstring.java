// THE PROBLEM STATEMENT IS TO FIND THE LENGTH OF THE LONGEST SUBSTRING WHICH CONTAINS DISTINCT CHARACTERS IN IT.

// MY APPROACH IS TO USE THE SLIDING WINDOW TECHNIQUE. SLIDE THE FIRST POINTER UNTIL THERE IS ONLY DISTINCT CHARACTERS IN THE SUBSTRING AND STORE THE CHARACTERS IN 
// A HASHMAP.THEN START DECREMENTING THE SLIDING WINDOW POINTER AND ALSO REMOVING THE CHARACTERS FROM THE HASHMAP IF THE FIRST POINTER COULDN'T MOVE AHEAD.

class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        // INITIALISING THE HASHMAP.
        HashMap<Character,Integer> dictionary = new HashMap<Character,Integer>();
        int index = 0;
        
        // SLIDING THE FIRST POINTER UNTIL THERE IS ONLY DISTINCT CHARACTERS IN THE SUBSTRING.
        while(index < s.length() && dictionary.get(s.charAt(index)) == null)
        {
            dictionary.put(s.charAt(index),1);
            index += 1;
        }
        
        int longestSubstringLength = index,slidingIndex = 0;
        
        // IF THE FIRST POINTER COULDN'T MOVE, START SLIDING THE SECOND POINTER.
        while(index < s.length())
        {
            if(dictionary.get(s.charAt(index)) == null)
            {
                dictionary.put(s.charAt(index),1);
                index += 1;
            }
            else
            {
                dictionary.remove(s.charAt(slidingIndex));
                slidingIndex += 1;
            }
            
            // CHECK FOR THE LONGEST LENGTH WHILE SLIDING.
            int len = index-slidingIndex;
            longestSubstringLength = Math.max(len,longestSubstringLength);
        }
        
        return longestSubstringLength;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
