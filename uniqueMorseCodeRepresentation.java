class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] umc = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<String,Integer> unique = new HashMap<String,Integer>();
        int ans = 0;
        
        for(int i=0;i<words.length;i++)
        {
            String umct = "";
            
            for(int j=0;j<words[i].length();j++)
            {
                int ind = words[i].charAt(j)-'a';
                umct += umc[ind];
            }
            
            if(unique.get(umct) == null)
            {
                unique.put(umct,1);
                ans++;
            }
            
        }
        
        return ans;
    }
}
