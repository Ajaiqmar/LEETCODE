# THE PROBLEM STATEMENT IS TO RETURN WHICH WORD IN THE SENTENCE HAS A PREFIX OF SEARCH WORD. IF MORE THAN ONE WORD HAS THE PREFIX RETURN THE
# FIRST WORD INDEX. IF THERE IS NOW WORD WITH THAT PREFIX RETURN -1.

# MY APPROACH IS TO SPLIT THE SENTENCE INTO WORDS THEN CHECK IF THE WORD CONTAINS THE PREFIX USING SLICING METHOD.

class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        sentence = sentence.split()
        
        # TRAVERSING THE WORDS IN THE SENTENCE.
        for i in range(len(sentence)):
            if(sentence[i][:len(searchWord)] == searchWord):
                return i+1
        
        return -1
        
# TIME COMPLEXITY : O(N*M) WHERE N IS THE NUMBER OF WORDS IN THE SENTENCE AND M IS THE NUMBER OF CHARACTERS IN EACH WORD.
# SPACE COMPLEXITY : O(1)
