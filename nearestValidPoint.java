class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minManhattanDistance = Integer.MAX_VALUE,minIndex = -1;
        
        for(int i=0;i<points.length;i++)
        {
            if(points[i][0] == x || points[i][1] == y)
            {
                int manhattanDistance = Math.abs(points[i][0]-x)+Math.abs(points[i][1]-y);
                
                if(manhattanDistance < minManhattanDistance)
                {
                    minManhattanDistance = manhattanDistance;
                    minIndex = i;
                }
            }
        }
        
        return minIndex;
    }
}
