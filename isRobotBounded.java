// THE PROBLEM STATEMENT IS TO RETURN TRUE IF AND ONLY IF THERE EXISTS A CIRCLE IN THE PLANE SUCH THAT THE ROBOT NEVER LEAVES THE CIRCLE. IN SIMPLER WORDS,
// WE HAVE TO RETURN TRUE WHETHER THE X - COORDINATE AND Y - COORDINATE REACHES 0 AFTER PERFORMING THE INSTRUCTIONS GIVEN AS A STRING, THE INSTRUCTIONS
// CAN BE REPEATED INFINITE NUMBER OF TIMES.

// MY APPROACH IS TO PERFORM THE STEPS IN THE GIVEN STRING INSTRUCTION THEN CHECK WHETHER X = 0 AND Y = 0 OR WHETHER THE DIRECTION IS NOT NORTH.
// BECAUSE BY THE END OF THE STRING IF X = 0 AND Y = 0 THEN THE CONDITION REMAINS TRUE OR IF THE DIRECTION IS NOT THE SAME THEN ALL THE VALUES IN X AND Y CAN GET 
// DECREMENTED BACK TO X = 0 AND Y = 0 BY IMPLEMENTING THE STEPS REPEATITIVELY.

class Solution 
{
    public boolean isRobotBounded(String instructions) 
    {
        int directionIndex = 0;
        int[][] directions = {{0,1},{-1,0},{0,-1},{1,0}};
        int x = 0,y = 0;
        
        // TRAVERSING THE GIVEN STRING.
        for(int i=0;i<instructions.length();i++)
        {
            if(instructions.charAt(i) == 'G')
            {
                x += directions[directionIndex][0];
                y += directions[directionIndex][1];
            }
            else if(instructions.charAt(i) == 'L')
            {
                directionIndex = (directionIndex+1)%4;
            }
            else if(instructions.charAt(i) == 'R')
            {
                directionIndex = directionIndex-1;
                
                if(directionIndex == -1)
                {
                    directionIndex = 3;
                }
            }
        }
        
        if(directionIndex != 0 || (x == 0 && y == 0))
        {
            return true;
        }
        
        return false;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1) SINCE THE DIRECTIONS ARRAY DOESN'T GROW LINEARLY.
