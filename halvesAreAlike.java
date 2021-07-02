class Solution {
    public boolean halvesAreAlike(String s) {
        int countOfVowelsInA = 0,countOfVowelsInB = 0;
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')
            {
                if(i<(s.length()/2))
                {
                    countOfVowelsInA += 1;
                }
                else
                {
                    countOfVowelsInB += 1;
                }
            }
        }
        
        return countOfVowelsInA == countOfVowelsInB;
    }
    
}
