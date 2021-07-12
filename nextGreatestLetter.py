class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        if((target >= letters[-1]) or (target < letters[0])):
            return letters[0]
        else:
            for i in range(1,len(letters)):
                if(target == letters[i-1] and target != letters[i]):
                    return letters[i]
                if(i< len(letters)-1 and target == letters[i] and target!=letters[i+1]):
                    return letters[i+1]
                if(target > letters[i-1] and target < letters[i]):
                    return letters[i]
