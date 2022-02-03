// PROBLEM DESCRIPTION : https://leetcode.com/problems/find-all-anagrams-in-a-string/

// MY APPROACH IS TO FIRST CHECK THE LENGTH OF S IS GREATER THAN OR EQUAL TO P ELSE RETURN THE EMPTY LIST. IF IT IS GREATER THAN OR EQUAL, THEN
// USE AN HASHTABLE TO STORE THE NUMBER OF OCCURRENCES OF LOWERCASE ALPHABETS IN STRING P, THEN TRAVERSE THE STRING S WITH A SLIDING WINDOW INDEX AND AN HASHTABLE TO FIND
// OUT THE NUMBER OF ANAGRAM'S OF P IN S.

class Solution 
{
    public List<Integer> findAnagrams(String s, String p) 
    {
        // ARRAY TO STORE THE STARTING INIDCES OF THE ANAGRAMS OF P IN S.
        List<Integer> ans = new ArrayList<Integer>();
        int n = s.length();
        int m = p.length();
        
        if(n < m)
        {
            return ans;
        }
        
        int[] hashTable = new int[26];
        
        // STORING THE NUMBER OF OCCURRENCES OF ALPHABETS OF P IN AN HASHTABLE. 
        for(int i=0;i<m;i++)
        {
            int hashKey = p.charAt(i)-'a';
            hashTable[hashKey] += 1;
        }
        
        int[] temp = new int[26];
        int slidingWindow = 0;
        
        // CHECKING FOR THE ANAGRAMS OF P IN S AND STORING THEIR STARTING INDICES.
        for(int i=0;i<n;i++)
        {
            int hashKey = s.charAt(i)-'a';
            temp[hashKey] += 1;
            
            if((i+1) == m)
            {
                Boolean flag = true;
                
                for(int j=0;j<26;j++)
                {
                    if(temp[j] != hashTable[j])
                    {
                        flag = false;
                        break;
                    }
                }
                
                if(flag)
                {
                    ans.add(slidingWindow);
                }
            }
            else if((i+1) > m)
            {
                hashKey = s.charAt(slidingWindow)-'a';
                temp[hashKey] -= 1;
                slidingWindow += 1;
                
                Boolean flag = true;
                
                for(int j=0;j<26;j++)
                {
                    if(temp[j] != hashTable[j])
                    {
                        flag = false;
                        break;
                    }
                }
                
                if(flag)
                {
                    ans.add(slidingWindow);
                }
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(MAX(N,M)) WHERE N IS THE LENGTH OF P AND M IS THE LENGTH OF S.
// SPACE COMPLEXITY : O(1)
