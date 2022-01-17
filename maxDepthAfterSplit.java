// PROBLEM DESCRIPTION : https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/ 

// MY APPROACH IS TO FIRST DIVIDE THE GIVEN STRING INTO VALID PARANTHESIS SUBSTRING, ALSO STORE THE MAX DEPTH OF THAT VALID PARANTHESIS SUBSTRING.
// NOW JUST TRAVERSE THE VALID PARANTHESIS SUBSTRING WHILE TRAVERSING MARK THE INDICES IN THE ANS ARRAY WHICH HAVE THE DEPTH LESS THAN HALF OF THE MAXDEPTH
// OF THE CURRENT SUBSTRING.

class Solution {
    public int[] maxDepthAfterSplit(String seq) 
    {
        // DECLARING THE DATA STRUCTURES THAT IS GOING TO BE USED IN THE MAIN FUNCTION.
        int depth = 0,maxDepth = 0,ind = 0;
        int[] ans = new int[seq.length()];
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<Integer> d = new ArrayList<Integer>();
        String st = "";
        
        // DIVIDING THE GIVEN STRING INTO VALID PARANTHESIS SUBSTRING.
        for(int i=0;i<seq.length();i++)
        {
            if(seq.charAt(i) == '(')
            {
                depth += 1;
            }
            
            if(seq.charAt(i) == ')')
            {
                depth -= 1;
            }
            
            st += seq.charAt(i);
            maxDepth = Math.max(maxDepth,depth);
            
            if(depth == 0)
            {
                s.add(st);
                d.add(maxDepth);
                
                maxDepth = 0;
                st = "";
            }
        }
        
        for(int i=0;i<s.size();i++)
        {
            if(d.get(i) > 1)
            {
                int dp = d.get(i)/2,dep = 0;
                String temp = s.get(i);
                
                for(int j=0;j<temp.length();j++)
                {
                    if(temp.charAt(j) == '(')
                    {
                        if(dep != 0 && dep <= dp)
                        {
                            ans[ind] = 1;
                        }
                        dep += 1;
                    }
                    
                    if(temp.charAt(j) == ')')
                    {
                        dep -= 1;
                        
                        if(dep != 0 && dep <= dp)
                        {
                            ans[ind] = 1;
                        }
                    }
                    ind += 1;
                }
            }
            else
            {
                ind += s.get(i).length();
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N) WHERE N IS THE LENGTH OF THE SEQUENCE 
// SPACE COMPLEXITY : O(M) WHERE M IS THE NUMBER OF VALID PARANTHESIS SUBSTRING.
