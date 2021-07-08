class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        alphabets = [0 for i in range(26)]
        countOfConsistent = 0
        
        for i in allowed:
            alphabets[ord(i)-ord('a')] = 1
        
        for i in range(len(words)):
            flag = 0
            for j in range(len(words[i])):
                if(alphabets[ord(words[i][j])-ord('a')] == 0):
                    flag = 1
                    break
            
            if(flag == 0):
                countOfConsistent += 1
            
        return countOfConsistent
