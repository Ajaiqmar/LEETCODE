class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character,Integer> jewel = new HashMap<Character,Integer>();
        int ans = 0;
        
        for(int i=0;i<jewels.length();i++)
        {
            jewel.put(jewels.charAt(i),1);
        }
        
        for(int i=0;i<stones.length();i++)
        {
            if(jewel.get(stones.charAt(i)) != null)
            {
                ans++;
            }
        }
        
        return ans;
    }
}
