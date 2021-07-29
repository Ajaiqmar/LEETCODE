// THE PROBLEM STATEMENT IS TO CHECK WHETHER THE BOTH THE STRINGS ARE EQUAL BY MAKING ATMOST ONE SWAP OPERATION.

// MY APPROACH IS TO CHCEK WHETHER BOTH THE STRING CONTAINS EQUAL NUMBER OF CHARACTERS, IF NOT RETURN FALSE, IF IT CONTAINS EQUAL NUMBER OF CHARACTERS THEN CHECK FOR NUMBER
// OF MISPLACED CHARCTERS, IF IT IS EQUAL TO TWO OR ZERO RETURN TRUE, ELSE FALSE.

class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        int countOfCharacters1[26]={0},countOfCharacters2[26]={0};
        
        // COUNTING THE NUMBER OF CHARCTERS.
        for(int i=0;i<s1.size();i++)
        {
            countOfCharacters1[s1[i]-'a']++;
            countOfCharacters2[s2[i]-'a']++;
        }
        
        // CHECKING IF THE OCCURRENCES MATCH.
        for(int i=0;i<26;i++)
        {
            if(countOfCharacters1[i]!=countOfCharacters2[i])
            {
                return false;
            }
        }
        
        int countOfMisplacedCharacters = 0;
        
        // FINDING THE NUMBER OF MISPLACED CHARCTERS.
        for(int i=0;i<s1.size();i++)
        {
            if(s1[i]!=s2[i])
            {
                countOfMisplacedCharacters++;
            }
        }
        
        // CHECKING WHETHER THE COUNT OF MISPLACED CHARACTER IS EQUAL TO 0 OR 2.
        if(countOfMisplacedCharacters == 0 || countOfMisplacedCharacters == 2)
        {
            return true;
        }
        
        return false;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
