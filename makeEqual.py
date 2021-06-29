class Solution(object):
    def makeEqual(self, words):
        letterFrequency = {}
        
        for word in words:
            for letter in word:
                if letter not in letterFrequency:
                    letterFrequency[letter] = 1
                else:
                    letterFrequency[letter] += 1
        
        for letter in letterFrequency:
            if(letterFrequency[letter]%len(words) != 0):
                return False
        
        return True
