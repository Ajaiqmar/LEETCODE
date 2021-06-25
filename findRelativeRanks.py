class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        sorted_score = sorted(score,reverse = True)
        d = {}
        
        for i in range(len(score)):
            if(i == 0):
                d[sorted_score[i]] = "Gold Medal"
            elif(i == 1):
                d[sorted_score[i]] = "Silver Medal"
            elif(i == 2):
                d[sorted_score[i]] = "Bronze Medal"
            else:
                d[sorted_score[i]] = "{}".format(i+1)
        
        return [d[i] for i in score]
