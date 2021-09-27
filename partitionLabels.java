// THE PROBLEM STATEMENT IS TO RETURN THE A LIST OF INTEGERS WHICH CONTAINS THE LENGTH OF SUBSTRINGS THAT CONTAINS CHARACTERS THAT ARE ONLY PRESENT
// IN THAT SUBSTRING AND NOT IN OTHERS. I.E IF THE GIVEN STRING IS "ababcbacadefegdehijhklij" THEN WE HAVE TO RETURN [9,7,8] WHERE EACH INDEX VALUE CORRESPONDS
// TO THE LENGTH OF THE SUBSTRING(["ababcbaca", "defegde", "hijhklij"]).

// MY APPROACH IS TO FIRSTLY MAKE NOTE OF THE NUMBER OF OCCURRENCE OF THE CHARACTERS IN THE GIVEN STRING USING A HASHTABLE, THEN TRAVERSE
// THE STRING ONCE MORE IN SUCH A WAY THAT, ONE HASHTABLE CONTAINS THE NUMBER OF OCCURRENCE OF THE CHARACTERS IN THE LEFT SUBSTRING
// AND ANOTHER HASHTABLE CONTAINS THE NUMBER OF OCCURRENCE OF THE CHARACTERS IN THE RIGHT SUBSTRING. NOW WE HAVE TO CHECK IF THE CHARACTERS PRESENT
// IN THE LEFT IS NOT PRESENT IN THE RIGHT IF IT IS, THEN APPEND THE COUNT TO THE ARRAY, AND THE REINITIALISE IT TO ZERO.  

class Solution 
{
    public List<Integer> partitionLabels(String s) 
    {
        // DECLARING AND INITIALISING THE HASHTABLES.
        int[] hashTable1 = new int[26];
        int[] hashTable2 = new int[26];
        List<Integer> ans = new ArrayList<Integer>();
        int count = 0;
        
        // TRAVERSING THE STRING TO CALCULATE THE NUMBER OF OCCURRENCE OF THE CHARACTERS IN THE GIVEN STRING.
        for(int i=0;i<s.length();i++)
        {
            hashTable1[s.charAt(i)-'a'] += 1;
        }
        
        // DIVIDING THE GIVEN STRING INTO SUBSTRINGS.
        for(int i=0;i<s.length();i++)
        {
            hashTable2[s.charAt(i)-'a'] += 1;
            hashTable1[s.charAt(i)-'a'] -= 1;
            count += 1;
            
            Boolean flag = true;
            for(int j=0;j<26;j++)
            {
                if(hashTable1[j] > 0 && hashTable2[j] != 0)
                {
                    flag = false;
                }
            }
            
            if(flag)
            {
                ans.add(count);
                count = 0;
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(26*N) == O(N) SINCE THE NUMBER OF ALPHABETS DOESN'T GROW LINEARLY ACCORDING TO EACH INPUTS.
// SPACE COMPLEXITY : O(MAX(26,M)) WHERE M IS THE NUMBER OF SUBSTRINGS.
