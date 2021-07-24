class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        alphabetValue = {}
        
        for i in range(len(order)):
            alphabetValue[order[i]] = (i+1)
        
        for i in range(len(words)-1):
            flag = 1
            
            for j in range(min(len(words[i]),len(words[i+1]))):
                
                if(alphabetValue[words[i][j]] > alphabetValue[words[i+1][j]]):
                    return False
                elif(alphabetValue[words[i][j]] < alphabetValue[words[i+1][j]]):
                    flag = 0
                    break
            
            if(flag and len(words[i]) > len(words[i+1])):
                return False
        
        return True
