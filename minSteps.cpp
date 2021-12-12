// THE PROBLEM STATEMENT IS TO RETURN HOW MANY CHARACTERS HAVE TO BE REPLACED IN THE STRING T TO MAKE THE STRING T AN ANAGRAM OF STRING S. N IS THE
// LENGTH OF STRING S AND T.

// MY APPROACH IS TO STORE THE NUMBER OF OCCURRENCES OF EACH CHARACTER IN STRING T IN A HASHTABLE AND AT THE SAME TIME DECREMENT THE NUMBER OF 
// OCCURRENCES OF EACH CHARACTER IN STRING S FROM THE HASHTABLE. THEN ATLAST TRAVERSE THE HASHTABLE AND ADD ALL THE VALUES WHICH ARE GREATER THAN 
// 0 WHICH WILL YIELD THE ANSWER.

class Solution 
{
public:
    int minSteps(string s, string t) 
    {
        int hash[26] = {0};
        int n = s.size();
        int ans = 0;
        
        // TRAVERSING THE STRINGS.
        for(int i=0;i<n;i++)
        {
            hash[t[i]-'a']++;
            hash[s[i]-'a']--;
        }
        
        // TRAVERSING THE HASHTABLE
        for(int i=0;i<26;i++)
        {
            if(hash[i] > 0)
            {
                ans += hash[i];
            }
        }
        
        return ans;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1) SINCE THE NUMBER OF ALPHABETS ARE ALWAYS GOING TO BE A CONSTANT AND DOESN'T GROW LINEARLY.
