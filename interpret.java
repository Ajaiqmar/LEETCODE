class Solution {
    public String interpret(String command) {
        String ans = "";
        
        int index = 0;
        while(index < command.length())
        {
            if(command.charAt(index) == 'G')
            {
                ans += 'G';
                index += 1;
            }
            else if(command.charAt(index) == '(' && command.charAt(index+1) == ')')
            {
                ans += 'o';
                index += 2;
            }
            else if(command.charAt(index) == '(' && command.charAt(index+1) == 'a')
            {
                ans += "al";
                index += 4;
            }
        }
        
        return ans;
    }
}
