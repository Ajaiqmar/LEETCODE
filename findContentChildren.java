class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i=0,j=0,ans=0;
        
        while(i<g.length && j<s.length)
        {
            if(g[i]<=s[j])
            {
                i+=1;
                j+=1;
                ans+=1;
            }
            else if(g[i]>s[j])
            {
                j+=1;
            }
        }
        
        return ans;
    }
}