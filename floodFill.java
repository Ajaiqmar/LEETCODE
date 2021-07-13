class Solution 
{
    public int[][] fill(int[][] matrix,int row,int col,int newColor,int currColor)
    {
        matrix[row][col] = newColor;
        
        if(row-1 >= 0 && matrix[row-1][col] == currColor)
        {
            matrix = this.fill(matrix,row-1,col,newColor,currColor);
        }
        
        if(col-1 >= 0 && matrix[row][col-1] == currColor)
        {
            matrix = this.fill(matrix,row,col-1,newColor,currColor);
        }
        
        if(row+1 < matrix.length && matrix[row+1][col] == currColor)
        {
            matrix = this.fill(matrix,row+1,col,newColor,currColor);
        }
        
        if(col+1 < matrix[0].length && matrix[row][col+1] == currColor)
        {
            matrix = this.fill(matrix,row,col+1,newColor,currColor);
        }
        
        return matrix;
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        if(newColor == image[sr][sc])
        {
            return image;
        }
        
        return this.fill(image,sr,sc,newColor,image[sr][sc]);
    }
}
