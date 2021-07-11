class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        alphabets = [0 for i in range(26)]
        completingWord = ""
        completingWordLength = sys.maxsize
        
        for i in licensePlate:
            if(i.isalpha()):
                alphabets[ord(i.lower())-ord('a')] += 1
        
        for i in range(len(words)):
            altemp = [0 for k in range(26)]
            flag = 0
            
            for j in words[i]:
                altemp[ord(j.lower())-ord('a')] += 1

            
            for j in range(26):
                if(alphabets[j] > 0):
                    if(alphabets[j] > altemp[j]):
                        flag = 1
                        break
            
            if(flag == 0):
                if(len(words[i]) < completingWordLength):
                    completingWordLength = len(words[i])
                    completingWord = words[i]
                
        
        return completingWord
