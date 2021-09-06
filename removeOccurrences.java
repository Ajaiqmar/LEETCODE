// THE PROBLEM STATEMENT IS TO RETURN A MODIFIED STRING OF S SUCH THAT IT DOES NOT CONTAIN ANY SUBSTRING WHICH IS EQUAL TO THE PART STRING.

// MY APPROACH IS TO USE THE STACK DATA STRUCTURE AND WHILE TRAVERSING THE STRING, INSERT EACH CHARCTER ONTO THE STACK, AFTER INSERTING AT EACH
// INDEX CHECK IF THE STACK LENGTH IS GRETER THAN THE PART STRING LENGTH ALSO CHECK WHETHER THE TOP CHARACTER IS EQUAL TO LAST CHARACTER OF THE STRING PART.
// IF IT IS CHECK IF THE TAIL OF THE STACK IS EQUAL TO THE PART STRING. IF IT IS REMOVE IT FROM THE STACK.

class Solution 
{
    public String removeOccurrences(String s, String part) 
    {
        if(part.length() > s.length())
        {
            return s;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        // TRAVERSING THE GIVEN STRING S.
        for(int i=0;i<s.length();i++)
        {
            stack.push(s.charAt(i));
            
            if(stack.size() >= part.length() && stack.peek() == part.charAt(part.length()-1))
            {
                String str = "";
                int len = part.length();
                
                while(len > 0)
                {
                    str = stack.pop()+str;
                    len -= 1;
                }
                
                if(!str.equals(part))
                {
                    for(int j=0;j<str.length();j++)
                    {
                        stack.push(str.charAt(j));
                    }
                }
            }
        }
        
        String ans = "";
        
        while(stack.size() > 0)
        {
            ans = stack.pop()+ans;
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*M) WHERE N IS THE LENGTH OF STRING S AND M IS THE LENGTH OF THE STRING PART.
// SPACE COMPLEXITY : O(N)
