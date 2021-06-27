class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        
        if(m*n == r*c):
            ans = []
            ar = []
            
            for i in range(m):
                for j in range(n):
                    ar.append(mat[i][j])
                    if(len(ar) == c):
                        ans.append(ar)
                        ar = []
            
            return ans
        
        return mat
