class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        ans = 0
        
        for i in range(len(items)):
            if(ruleKey == "type"):
                if(items[i][0] == ruleValue):
                    ans+=1
            elif(ruleKey == "color"):
                if(items[i][1] == ruleValue):
                    ans+=1
            elif(ruleKey == "name"):
                if(items[i][2] == ruleValue):
                    ans+=1
            
        return ans
