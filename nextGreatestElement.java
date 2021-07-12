class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char smallestChar = ' ';
        int distance = Integer.MAX_VALUE;
        
        for(int i=0;i<letters.length;i++)
        {
            if(letters[i] != target)
            {
                if(letters[i] < target)
                {
                    int temp = ('z'-target)+(letters[i]-'a')+1;
                    if(temp < distance)
                    {
                        smallestChar = letters[i];
                        distance = temp;
                    }
                }
                else
                {
                    if((letters[i]-target) < distance)
                    {
                        smallestChar = letters[i];
                        distance = letters[i]-target;
                    }
                }
            }
        }
        
        return smallestChar;
    }
}
