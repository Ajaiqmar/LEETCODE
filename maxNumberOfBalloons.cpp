// THE PROBLEM STATEMENT IS TO RETURN THE MAXIMUM NUMBER OF THE WORD "BALLOON" CAN BE FORMED WITH THE GIVEN CHARACTERS FROM THE STRING TEXT.

// MY APPROACH IS TO US THE HASHTABLE TO RETRIEVE THE TOTAL NUMBER OF OCCURRENCE OF THE CHARACTERS IN THE STRING TEXT, THEN WE COULD CALCULATE THE
// MAXIMUM NUMBER OF OCCURRENCE USING THE HASHTABLE.

class Solution {
public:
    int maxNumberOfBalloons(string text) {
        string a = "balloon";
        int hashTable[26] = {0};
        int ans = INT_MAX;
        
        // TRAVERSING THE GIOVEN STRING TEXT.
        for(int i=0;i<text.size();i++)
        {
            hashTable[text[i]-'a'] += 1;
        }
        
        for(int i=0;i<a.size();i++)
        {
            if(a[i] == 'l' || a[i] == 'o')
            {
                ans = min(ans,hashTable[a[i]-'a']/2);
            }
            else
            {
                ans = min(ans,hashTable[a[i]-'a']);
            }
        }
        
        return ans;
    }
};

// TIME COMPLEXITY : O(N) WHERE N IS THE LENGTH OF THE STRING.
// SPACE COMPLEXITY : O(1) SINCE THE NUMBER OF ALPHABETS DOESN'T VARY LINERALY ACCORDING TO THE INPUTS.
