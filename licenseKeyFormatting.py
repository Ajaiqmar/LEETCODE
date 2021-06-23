class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        st = ""
        
        for i in s.split("-"):
            st+=(i.upper())
        
        v = len(st)%k
        if(v == 0):
            v = k
        
        ans = [st[:v]]
        
        for i in range(v,len(st),k):
            ans.append(st[i:i+k])
        
        
        return "-".join(ans)
