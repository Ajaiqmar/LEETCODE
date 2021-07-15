class Solution 
{
    public int maxLengthBetweenEqualCharacters(String s) 
    {
        int[] alphabet = new int[26];
        int largestNoOfCharacters = -1;
        
        for(int i=0;i<s.length();i++)
        {
            int ind = s.charAt(i)-'a';
            
            if(alphabet[ind] == 0)
            {
                alphabet[ind] = i+1;
            }
            else
            {
                if((i-alphabet[ind]) > largestNoOfCharacters)
                {
                    largestNoOfCharacters = i-alphabet[ind];
                }
            }
        }
        
        return largestNoOfCharacters;
    }
}
