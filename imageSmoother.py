class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        ans = []
        
        for i in range(len(img)):
            val = []
            for j in range(len(img[i])):
                average = img[i][j]
                countOfCells = 1
                
                if(i>0):
                    countOfCells += 1
                    average += img[i-1][j]
                    
                if(j>0):
                    countOfCells += 1
                    average += img[i][j-1]
                    
                if(i>0 and j>0):
                    countOfCells += 1
                    average += img[i-1][j-1]
                
                if(i<len(img)-1):
                    countOfCells += 1
                    average += img[i+1][j]
                    
                if(j<len(img[i])-1):
                    countOfCells += 1
                    average += img[i][j+1]
                    
                if(i<len(img)-1 and j<len(img[i])-1):
                    countOfCells += 1
                    average += img[i+1][j+1]
                
                if(i>0 and j<len(img[i])-1):
                    countOfCells += 1
                    average += img[i-1][j+1]
                    
                if(i<len(img)-1 and j>0):
                    countOfCells += 1
                    average += img[i+1][j-1]
                
                val.append(average//countOfCells)
            
            ans.append(val)
        
        return ans
                
