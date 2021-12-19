// THE PROBLEM STATEMENT IS TO DECODE THE GIVEN ENCODED STRING. THE ENCODING RULE IS: K[ENCODED_STRING], WHERE THE ENCODED_STRING INSIDE THE SQUARE BRACKETS IS 
// BEING REPEATED EAXCTLY K TIMES. NOTE THE K IS GUARANTEED TO BE A POSITIVE INTEGER.
// YOU MAY ASSUME THAT THE INPUT STRING IS ALWAYS VALID; NO EXTRA WHITE SPACES, SQUARE BTRACKETS ARE WELL-FORMED, ETC.

// MY APPORACH IS TO USE STACK DATA STRUCTURE INORDER TO DECODE THE GIVEN STRING. WE TRAVERSE THE GIVEN STRING, IF THE CHARACTERS IS AN ALPHABET 
// , IF IT IS NOT ENCLOSED WITHIN THE SQUARE BRACKET AND IF THE STACK IS EMPTY THEN WE ADD THE CHARACTER TO THE ANSWER ELSE IF THE STACK IS NOT
// EMPTY AND THE OTHER CONDITIONS REMAIN TRUE, THEN ADD THE CURRENT CHARACTER TO THE STRING AT THE TOP OF THE STACK. ELSE IF THE CHARACTER
// IS ENCLOSED WITHIN THE BRACKET WE ADD IT TO THE STRING AT THE TOP OF THE STACK ELSE IF CHARACTER IS A DIGIT, THEN WE APPEND IT TO THE TOP OF THE STACK.
// IF THE CURRENT CHARACTER IS ']', THEN WE SHOULD CHECK IF THE STACK IS EMPTY IF IT IS APPEND IT TO THE STRING ELSE APPEND IT TO THE STRING
// AT THE TOP OF THE STACK.

class Solution {
public:
    string decodeString(string s) 
    {
        // INITIALISING THE STACK.
        stack<int> digit;
        stack<string> alphabet;
        int aflag = 0,dflag = 0;
        string ans = "";
        
        // TRAVERSING THE ENCODED STRING.
        for(int i=0;i<s.size();i++)
        {
            // IF THE CURRENT CHARACTER IS ALPHABET
            if(isalpha(s[i]))
            {
                if(aflag)
                {
                    string temp = alphabet.top();
                    temp += s[i];
                    
                    alphabet.pop();
                    alphabet.push(temp);
                }
                else
                {
                    if(alphabet.empty())
                    {
                        ans += s[i];
                    }
                    else
                    {
                        string temp = alphabet.top();
                        temp += s[i];
                        
                        alphabet.pop();
                        alphabet.push(temp);
                    }
                }
            }
            // IF THE CURRENT CHARACTER IS DIGIT.
            else if(isdigit(s[i]))
            {
                if(dflag)
                {
                    int temp = digit.top();
                    temp = (temp*10)+(s[i]-'0');
                    
                    digit.pop();
                    digit.push(temp);
                }
                else
                {
                    int temp = s[i]-'0';
                    digit.push(temp);
                    
                    dflag = 1;
                }
            }
            else if(s[i] == '[')
            {
                string temp = "";
                alphabet.push(temp);
                
                aflag = 1;
                dflag = 0;
            }
            else if(s[i] == ']')
            {
                int d = digit.top();
                string s = alphabet.top();
                
                digit.pop();
                alphabet.pop();
                
                if(alphabet.empty())
                {
                    for(int i=0;i<d;i++)
                    {
                        ans += s;
                    } 
                }
                else
                {
                    string temp = alphabet.top();
                    for(int i=0;i<d;i++)
                    {
                        temp += s;
                    }
                    
                    alphabet.pop();
                    alphabet.push(temp);
                }
                
                aflag = 0;
            }
        }
        
        return ans;
    }
};

// TIME COMPLEXITY : O(M).
// SPACE COMPLEXITY : O(M) WHERE M IS THE LENGTH OF THE DECODED STRING.
