class Solution {
    public int countBinarySubstrings(String s) {
        Stack<Character> stack = new Stack<Character>();
        int ans = 0;
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '1')
            {
                if((!stack.empty()) && stack.peek() == '0')
                {
                    ans++;
                    stack.pop();
                }
            }
            else
            {
                if(i == 0 || s.charAt(i-1) == '0')
                {
                    stack.push(s.charAt(i));
                }
                else
                {
                    stack.removeAllElements();
                    stack.push(s.charAt(i));
                }
            }
        }
        
        stack.removeAllElements();
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '0')
            {
                if((!stack.empty()) && stack.peek() == '1')
                {
                    ans++;
                    stack.pop();
                }
            }
            else
            {
                if(i == 0 || s.charAt(i-1) == '1')
                {
                    stack.push(s.charAt(i));
                }
                else
                {
                    stack.removeAllElements();
                    stack.push(s.charAt(i));
                }
            }
        }
        
        stack.removeAllElements();
        
        return ans;
    }
}
