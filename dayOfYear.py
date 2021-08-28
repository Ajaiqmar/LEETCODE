# THE PROBLEM STATEMENT IS TO PRINT THE DAY OF THE YEAR WHEN THE DATE IS GIVEN.

# MY APPROACH IS TO USE THE STRFTIME FUNCTION IN THE DATE CLASS.

class Solution:
    def dayOfYear(self, da: str) -> int:
        da = da.split('-')
        
        d = date(int(da[0]),int(da[1]),int(da[2]))
        
        return int(d.strftime("%j"))
