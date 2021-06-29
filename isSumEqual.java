class Solution {
    public int returnNumericalValue(String str)
    {
        int val = 0,places = 0;
        
        for(int i=str.length()-1;i>=0;i--)
        {
            int ch = str.charAt(i), def = 'a';
            val += ((ch-def)*(Math.pow(10,places)));
            places += 1;
        }
        
        return val;
    }
    
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int firstWordValue = this.returnNumericalValue(firstWord);
        int secondWordValue = this.returnNumericalValue(secondWord);
        int targetWordValue = this.returnNumericalValue(targetWord);
        
        if(firstWordValue+secondWordValue == targetWordValue)
        {
            return true;
        }
        return false;
    }
}
