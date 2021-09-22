// THE PROBLEM STATEMENT IS TO REVERSE THE WORDS IN A STRING.
// I.E. IF THE GIVEN STRING IS "the sky is blue" THEN WE HAVE TO OBTAIN "blue is sky the".

// MY APPROACH IS TO FIRST DIVIDE THE GIVEN SENTENCE INTO AN ARRAY OF WORDS. THEN TRAVERSE THE ARRAY FROM REVERSE TO RECREATE THE STRING
// WE NEED TO OBTAIN.

// FOLLOW UP QUESTION WAS IF WE ARE USING A LANGUAGE WHERE THE STRING DATA TYPE IS MUTABLE, THEN COULD I COME UP WITH A SOLUTION WHICH
// TAKES UP O(1) EXTRA SPACE. WELL, IN THIS CASE, WE HAVE TO REVERSE EACH WORD IN THE STRING, THEN REVERSE THE WHOLE STRING.

class Solution {
public:
    string reverseWords(string s) 
    {
        int find = 0,lind = s.size()-1;
        
        // REMOVING ANY LEADING ZEROS.
        while(s[find] == ' ')
        {
            find += 1;
        }
        
        // REMOVING ANY TRAILING ZEROS.
        while(s[lind] == ' ')
        {
            lind -= 1;
        }
        
        vector<string> arr;
        
        // TRAVERSING THE GIVEN SENTENCE.
        while(find <= lind)
        {
            string temp;
            
            while(s[find] != ' ' && find <= lind)
            {
                temp += s[find];
                find += 1;
            }
            
            arr.push_back(temp);
            
            while(s[find] == ' ')
            {
                find += 1;
            }
        }
        
        string ans;
        
        // TRAVERSING THE ARRAY OF WORDS.
        for(int i=(arr.size()-1);i>=0;i--)
        {
            ans += arr[i];
            
            if(i > 0)
            {
                ans += ' ';
            }
        }
        
        return ans;
    }
};

// TIME COMPLEXITY : O(N) WHERE N IS THE NUMBER OF CHARACTERS IN THE GIVEN STRING.
// SPACE COMPLEXITY : O(M*L) WHERE M IS THE NUMBER OF WORDS IN THE SENTENCE AND L IS THE NUMBER OF CHARACTERS IN EACH WORD.
