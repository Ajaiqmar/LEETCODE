class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<String>();
        HashMap<String,Integer> dv = new HashMap<String,Integer>();
        
        for(int i=0;i<cpdomains.length;i++)
        {
            String[] pair = cpdomains[i].split(" ");
            
            int visits = Integer.parseInt(pair[0]);
            String[] domain = pair[1].split("\\.");
            String d = "";
            
            for(int j=domain.length-1;j>=0;j--)
            {
                if(j == domain.length-1)
                {
                    d = d+domain[j];
                }
                else
                {
                    d = domain[j]+"."+d;
                }
                
                if(dv.get(d) == null)
                {
                    dv.put(d,visits);
                    ans.add(d);
                }
                else
                {
                    dv.put(d,visits+dv.get(d));
                }
            }
        }
        
        for(int i=0;i<ans.size();i++)
        {
            ans.set(i,dv.get(ans.get(i))+" "+ans.get(i));
        }
        
        return ans;
    }
}
