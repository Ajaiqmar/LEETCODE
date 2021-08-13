// THE PROBLEM STATEMENT IS TO RETURN THE STRING AFTER REMOVING THE DUPLICATES CHARACTERS.
// DUPLICATE CHARACTERS ARE TWO CHARACTERS THAT OCCUR SIDE BY SIDE.

// MY APPROACH IS TO USE A STACK DATA STRUCTURE. TRAVERSE THE STRING, IF THE TOP OF THE STACK IS SAME AS THE PRESENT CHARACTER, POP IT
// ELSE, INSERT THE PRESENT CHARACTER ONTO THE STACK. FINALLY, EMPTY THE STACK AND FORM A STRING USING THE CHARACTERS IN THE STACK.

class Solution 
{
    public String removeDuplicates(String s) 
    {
        // INITIALISNG THE STACK DATA STRUCTURE.
        Stack<Character> stack = new Stack<Character>();
        
        // TRAVERSE THE GIVEN STRING AND INSERT ONTO THE STACK UNDER THE GIVEN CONDITIONS.
        for(int i=0;i<s.length();i++)
        {
            if(stack.isEmpty())
            {
                stack.push(s.charAt(i));
            }
            else if(stack.peek() != s.charAt(i))
            {
                stack.push(s.charAt(i));
            }
            else
            {
                stack.pop();
            }
        }
        
        String ans = "";
        
        // EMPTY THE STACK AND FORM A STRING.
        while(!stack.isEmpty())
        {
            ans = stack.pop()+ans;
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
