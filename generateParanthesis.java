// THE PROBLEM STATEMENT IS TO RETURN LIST OF DIFFERENT TYPES OF BALANCED PARANTHESIS STRING OF LENGTH 2*N.
// I.E. IF N IS 3 THEN WE HAVE TO RETURN ["((()))","(()())","(())()","()(())","()()()"].

// MY APPROACH IS TO USE THE RECURSIVE FUNCTIONS TO SOLVE THE PROBLEM. FIRST WE MAKE A FUNCTION CALL TO THE EXPLORING PATHS FUNCTION,
// IN WHICH WE CHECK IF NLP AND NRP IS EQUAL TO N IF IT IS ADD THE STRING TO THE LIST, ELSE IF NLP IS GREATER THAN NRP WE CALL TWO RECURSIVE FUNCTIONS
// ADDING A OPEN PARANTHESIS IN ONE FUNCTION CALL AND A CLOSED PARANTHESIS IN THE OTHER. ELSE WE ONLY HAVE TO CALL A SINGLE FUNCTION ADDING ONLY OPEN PARANTHESIS
// TO THE GIVEN STRING. THE REASON IS BEACAUSE THEY HAVE ASKED TO RETURN A LIST OF BALANCED PARANTHESIS STRINGS.

class Solution {
    // FUNCTION TO EXPLORE DIFFERENT BALANCED PARANTHESIS STRINGS.
    public static void exploringPaths(List<String> arr,int nlp,int nrp,String s,int n)
    {
        if(nlp == n && nrp == n)
        {
            arr.add(s);
            return;
        }
        
        if(nlp > nrp)
        {
            if(nlp < n)
            {
                exploringPaths(arr,nlp+1,nrp,s+"(",n);
            }
            
            if(nrp < n)
            {
                exploringPaths(arr,nlp,nrp+1,s+")",n);
            }
        }
        else
        {
            if(nlp < n)
            {
                exploringPaths(arr,nlp+1,nrp,s+"(",n);
            }
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        
        exploringPaths(ans,0,0,"",n);
        
        return ans;
    }
}

// TIME COMPLEXITY : O(2^N) BECAUSE EACH CHARACTER POSITION IN THE BALANCED PARANTHESIS CAN BE OCCUPIED BY EITHER "(" OR ")". SO TIME COMPLEXITY 
//                   OF STRING OF LENGTH N IS 2^N.
// SPACE COMPLEXITY : O(2^N)
