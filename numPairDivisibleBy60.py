# THE PROBLEM STATEMENT IS TO FIND THE NUMBER OF PAIRS WHOSE SUM IS DIVISIBLE 60. LET THE PAIR BE (TIMES[I] + TIMES[J])%60 == 0 WHERE I < J.

# MY APPROACH IS TO TRAVERSE THE ARRAY THEN USE A HASHTABLE TO STORE THE REMAINDER OF EACH INDEX VALUE WHEN DIVIDED BY 60, ALSO WHILE TRAVERSING
# CHECK IF THE VALUE OF ((60 - REMAINDER)%60) IN THE HASHTABLE IS GREATER THAN 0, IF IT IS THEN ADD IT TO THE ANSWER VALUE. FINALLY RETURN THE ANSWER.

class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        hashTable = [0 for i in range(60)]
        ans = 0
        
        for i in time:
            
            v = i%60
            
            if(hashTable[(60-v)%60] > 0):
                ans += hashTable[(60-v)%60]
                
            hashTable[v] += 1
        
        return ans
      
# TIME COMPLEXITY : O(N) WHERE N IS THE LENGTH OF THE ARRAY.
# SPACE COMPLEXITY : O(1) BECAUSE THE LENGTH OF THE HASHTABLE DOESN'T GROW LINEARLY.
