class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        ans = []
        
        for i in range(0,12):
            for j in range(0,60):
                
                h = (bin(i)[2:]).count("1")
                m = (bin(j)[2:]).count("1")
                
                
                if(h+m == turnedOn):
                    ans.append("{}:{:02d}".format(i,j))
        
        return ans
