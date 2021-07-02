class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        d = {}
        
        for i in range(len(edges)):
            if edges[i][0] not in d:
                d[edges[i][0]] = 1
            else:
                d[edges[i][0]] += 1
                
            if edges[i][1] not in d:
                d[edges[i][1]] = 1
            else:
                d[edges[i][1]] += 1
            
            if(d[edges[i][0]] == len(edges)):
                return edges[i][0]
            
            if(d[edges[i][1]] == len(edges)):
                return edges[i][1]
