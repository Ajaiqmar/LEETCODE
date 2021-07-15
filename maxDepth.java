class Solution {
    public int maxDepth(String s) {
        int nestingDepth = 0,countOfParanthesis = 0;
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
            {
                countOfParanthesis++;
            }
            else if(s.charAt(i) == ')')
            {
                countOfParanthesis--;
            }
            
            if(countOfParanthesis > nestingDepth)
            {
                nestingDepth = countOfParanthesis;
            }
        }
        
        return nestingDepth;
    }
}
