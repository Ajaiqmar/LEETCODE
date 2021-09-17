# THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF ITEMS IN THE ITEMS THAT MATCH THE RULEVALUE ACCORDING TO THE RULEKEY. EACH ITEM IN THE ITEMS 
# ARRAY HAS AN ARRAY OF STRING CONTAINING [TYPE,COLOR,NAME] OF THAT ITEM. THE RULEKEY WILL BE ANY ONE OF THE KEYS IN THE GIVEN ARRAY INSTANCE AND RULEVALUE CORRESPONDS
# TO ITS VALUE.

# MY APPROACH IS TO TRAVERSE THE ITEMS ARRAY AND ACCORDING TO THE GIVEN KEY CHECK IF THE RULE VALUE MATCHES THE GIVEN ARRAY IONSTANCE VALUE. IF IT IS INCREMENT THE
# VALUE OF ANSWER.

class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        ans = 0
        
        # TRAVERSING THE GIVEN ITEMS ARRAY.
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
    
# TIME COMPLEXITY : O(N)
# SPACE COMPLEXITY : O(1)
