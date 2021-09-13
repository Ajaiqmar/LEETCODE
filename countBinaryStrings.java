// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF SUBSTRING FROM THE BINARY STRING CONTAINS EQUAL NUMBER OF ONES AND ZEROS.

// MY APPROACH IS TO USE THE STACK DATA STRUCTURE, AND CHECK FOR NUMBER OF CONTINOUS OCCURRENCE OF ZEROS FOLLOWED BY THE NUMBER OF
// CONTINOUS OCCURRENCES OF ONES BY TRAVERSING FROM LEFT TO RIGHT AND RIGHT TO LEFT. WHILE TRAVERSING IF THE CURRENT CHARACTER IS '0' INSERT IT INTO THE STACK
// ELSE IF IT IS '1' CHECK IF THE STACK IS NOT EMPTY,IF IT IS NOT INCREMENT THE ANS VARIABLE AND REMOVE THE TOP ELEMENT. BEFORE GOING TO THE NEXT SET
// ZEROS AND ONES, WE HAVE TO EMPTY THE STACK AND DO THE ABOVE OPERATIONS AGAIN.

class Solution {
    public int countBinarySubstrings(String s) {
        Stack<Character> stack = new Stack<Character>();
        int ans = 0;
        
        // TRAVERSING THE STRING S FROM LEFT TO RIGHT.
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
        
        // TRAVERSING THE STRING S FROM RIGHT TO LEFT.
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

// TIME COMPLEXITY: O(N)
// SPACE COMPLEXITY : O(N)
