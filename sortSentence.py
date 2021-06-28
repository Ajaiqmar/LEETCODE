class Solution:
    def sortSentence(self, s: str) -> str:
        s = s.split()
        stringTable = ["" for i in range(10)]
        
        for i in s:
            stringTable[int(i[-1])-1] = i[:len(i)-1]
        
        return " ".join(stringTable).strip()
