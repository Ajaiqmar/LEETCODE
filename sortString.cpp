// THE PROBLEM STATEMENT IS TO RETURN THE SORTED STRING. THE ALGORITHM IS GIVEN AS:

// PICK THE SMALLEST CHEARCTER FROM S AND APPEND IT TO THE RESULT. 
// PICK THE SMALLEST CHARACTER FROM S WHICH IS GREATER THAN THE LAST APPENDED CHARCTER TO THE RESULT AND APPEND IT.
// REPEAT STEP 2 UNTIL YOU CANNOT PICK MORE CHARACTERS.
// PICK THE LARGEST CHARACTER FROM S AND APPEND IT TO THE RESULT.
// PICK THE LATRGEST CHARACTER FROM S WHICH IS SMALLER THAN THE LAST APPENDED CHARCTER TO THE RESULT AND APPEND IT.
// REPEAT STEP 5 UNTIL YOU CANNOT PICK MORE CHARACTERS.
// REPEAT THE STEPS FROM 1 TO 6 UNTIL YOU PICK ALL CHARACTERS FROM S. 

// MY APPROACH IS TO FIRST STORE THE CHARACTER AND THEIR OCCURRENCES IN A HASHTABLE. THEN TRAVERSE THE HASHTABLE FROM TOP TO BOTTOM AND THEN BOTTOM TO TOP AND IF THE
// IT IS PRESENT IN THE STRING THEN ADD IT TO THE STRING AS YOU ARE TREVERSING. DO IT UNTIL THE LENGTH THE ANS STRING IS EQUAL TO THE GIVEN STRING.

class Solution 
{
public:
    string sortString(string s)
    {
        int alphabets[26] ={0};
        string ans = "";
        
        // TRAVERSING THE GIVEN STRING AND STORING THEIR OCCURRENCES.
        for(int i=0;i<s.size();i++)
        {
            alphabets[s[i]-'a'] += 1;
        }
        
        int length = 0;
        
        // WHILE LENGTH OF BOTH THE STRINGS ARE EQUAL TRAVERSE THE HASH TABLE FROM TOP TO BOTTOM THEN FROM BOTTOM TO TOP.
        while(length < s.size())
        {
            for(int i=0;i<26;i++)
            {
                if(alphabets[i] > 0)
                {
                    length += 1;
                    ans += (i+'a');
                    alphabets[i] -= 1;
                }
            }
            
            for(int i=25;i>=0;i--)
            {
                if(alphabets[i] > 0)
                {
                    length += 1;
                    ans += (i+'a');
                    alphabets[i]-=1;
                }
            }
        }
        return ans;
    }
};

// TIME COMPLEXITY : O(52*X) WHERE X IS THE NUMBER OF TIMES THE ALGORITH IS APPLIED.
// SPACE COMPLEXITY : O(1) SINCE THE HASHTABLE SIZE DOESN'T GROW LINEARLY, THEN MATHEMATICALLY SPACE COMPLEXITY WOULD BE O(1).
