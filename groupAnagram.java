// THE PROBLEM STATEMENT IS TO GROUP THE GIVEN 1D LIST OF STRINGS INTO 2D LIST OF STRINGS, IN EACH ROW OF THE 2D LIST, STRINGS WHICH ARE ANAGRAMS
// ARE GROUPED. TWO STRINGS ARE SAID TO BE ANAGRAM OF EACH OTHER IF BOTH THE STRINGS CONTAINS SAME ALPAHBETS AND SAME FREQUENCY OF ALPHABETS.
// I.E : THE GIVEN LIST OF STRINGS ARE ["eat","tea","tan","ate","nat","bat"] AND WE HAVE TO RETURN [["bat"],["nat","tan"],["ate","eat","tea"]].

// MY APPROACH IS TO FIRST TRAVERSE THE LIST OF STRINGS AND MAKE NOTE OF THE ALPHABTES AND THE FREQUENCY OF ALPHABETS IN THE STRING, THEN CREATE
// A KEY OUT OF THOSE AND GROUP THESE STRINGS USING AN HASHMAP OR DICTIONARY. THEN CONVERT THE GIVEN HASHMAP INTO A 2D LIST OF STRINGS.

class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        HashMap<String,ArrayList<String>> hashmap = new HashMap<String,ArrayList<String>>();
        ArrayList<String> str = new ArrayList<String>();
        
        // TRAVERSING THE GIVEN LIST OF STRINGS.
        for(int i=0;i<strs.length;i++)
        {
            int[] arr = new int[26];
            String s = "";
            
            // MAKING NOTE OF THE FREQUENCY OF ALPHABTES.
            for(int j=0;j<strs[i].length();j++)
            {
                arr[strs[i].charAt(j)-'a'] += 1;
            }
            
            // CREATING A KEY
            for(int j=0;j<26;j++)
            {
                s += arr[j];
                s += "-";
            }
            
            if(hashmap.get(s) == null)
            {
                ArrayList<String> a = new ArrayList<String>();
                a.add(strs[i]);
                str.add(s);
                hashmap.put(s,a);
            }
            else
            {
                ArrayList<String> a = hashmap.get(s);
                a.add(strs[i]);
            }
        }
        
        List<List<String>> ans = new ArrayList<List<String>>();
        
        for(int i=0;i<str.size();i++)
        {
            ans.add(hashmap.get(str.get(i)));
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF CHARACTERS IN THE GIVEN LIST OF STRINGS.
// SPACE COMPLEXITY : O(M*L) WHERE M IS THE NUMBER OF ANAGRAM GROUPS AND L IS THE NUMBER OF STRINGS IN THAT GROUP.
