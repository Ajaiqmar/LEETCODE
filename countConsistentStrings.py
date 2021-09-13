# THE PROBLEM STATEMENT IS TO RETURN THE NUJMBER OF CONSISTENT STRINGS IN THE GIVEN ARRAY WORDS. A STRING IS SAID TO BE CONSISTENT, IF IT CONTAINS
# ONLY THE CHARACTERS THAT ARE PRESENT IN THE STRING ALLOWED.

# MY APPROACH IS TO STORE CHARACTERS PRESENT IN THE ALLOWED STRING IN AN HASHTABLE, THEN TRAVERSE EACH STRING IN THE GIVEN ARRAY, THEN FOR EACH
# STRING, CHECK IF THERE IS A CHARACTER THAT IS NOT PRESENT THE ALLOWED STRING, IF IT IS PRESENT THEN CONTINUE TO THE NEXT STRING, ELSE INCREMENT THE
# COUNT OF CONSISTENT COUNTER.

class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        alphabets = [0 for i in range(26)]
        countOfConsistent = 0
        
        # STORING THE CHARACTERS OF THE ALLOWED STRING IN AN HASHTABLE.
        for i in allowed:
            alphabets[ord(i)-ord('a')] = 1
        
        # TRAVERSING THE ARRAY OF STRINGS.
        for i in range(len(words)):
            flag = 0
            for j in range(len(words[i])):
                if(alphabets[ord(words[i][j])-ord('a')] == 0):
                    flag = 1
                    break
            
            if(flag == 0):
                countOfConsistent += 1
            
        return countOfConsistent
    
# TIME CIOMPLEXITY : O(N) WHERE N IS THE NUMBER OF CHARACTERS IN THE ARRAY OF STRINGS.
# SPACE COMPLEXITY : O(1) SINCE THE NUMBER OF ALPHABETS IN ENGLISH DOESN'T GROW LINEARLY.
