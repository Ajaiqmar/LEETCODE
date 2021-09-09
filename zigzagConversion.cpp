// THE PROBLEM STATEMENT IS TO RETURN THE MODIFIED STRING OF THE GIVEN STRING. THE RULES TO MODIFY ARE:
// FIRST ARRANGE THE STRING IN A ZIG-ZAG MANNER ACCORDING TO THE GIVEN NUMBER OF ROWS. THEN CREATE A STRING BY APPENDING THE CHARACTERS FROM THAT ZIG-ZAG VERSION
// AND RETURN IT.
// I.E. s = "PAYPALISHIRING", numRows = 3,
// ARRANGING THE STRING IN A ZIG-ZAG MANNER, 
// P   A   H   N
// A P L S I I G
// Y   I   R
// THE RETURNED STRING IS "PAHNAPLSIIGYIR".

// MY APPROACH IS TO CREATE A FOR LOOP OF RANGE NUMROWS. THEN AT EACH INDEX TRAVERSE EACH ROW'S CHARACTERS OF THE ZIG-ZAG VERSION USING A WHILE LOOP.

class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows >= s.size() || numRows == 1)
        {
            return s;
        }
        
        string ans = "";
        // CREATING A FOR BLOCK OF RANGE NUMROWS.
        for(int i=0;i<numRows;i++)
        {
            int ind = i;
            
            // TRAVERSING THE CHARACTERS IN EACH ROW OF THE ZIG-ZAG VERSION.
            while(ind < s.size())
            {
                if(i == 0 || i == numRows-1)
                {
                    ans += s[ind];
                }
                else
                {
                    ans += s[ind];
                    int sind = ind+((numRows-(i+1))*2);
                    
                    if(sind < s.size())
                    {
                        ans += s[sind];
                    }
                }
                ind += ((numRows-1)*2);
            }
        }
        
        return ans;
    }
};

// TIME COMPLEXITY : O(N) WHERE N IS THE LENGTH OF THE GIVEN STRING.
// SPACE COMPLEXITY : O(N)
