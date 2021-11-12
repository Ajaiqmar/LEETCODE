// THE PROBLEM STATEMENT IS TO FIND ALL THE PATHS BETWEEN THE NODE 0 TO N-1 IN THE DIRECTED ACYCLIC GRAPH(DAC) WHERE N IS THE LENGTH OF THE GIVEN GRAPH ARRAY.
// THE GRAPH 2D ARRAY REPRESENTS THE NODES TO WHICH THE NODE I IS CONNECTED TO, WHERE I IS THE INDEX IN RANGE FROM 0 TO N-1.

// MY APPROACH IS TO USE RECURSION TO ESTABLISH EVERY PATHS FROM THE NODE 0 TO NODE N-1. IN THE FINDPATHS FUNCTION, WE WILL BE STARTING FROM THE NODE 0 
// THEN WE WILL MOVE ONTO THE NODES THAT ARE CONNECTED TO THE CURRENT NODE. WE WILL REPEAT THE PROCESS UNTIL THE NODE REACHES THE NODE N-1, IF IT
// REACHES NODE N-1 THEN WE WILL ADD IT TO OUR ANS 2D ARRAY. WE WILL ALSO BE USING A VISITED ARRAY TO AVOID CYCLIC PATHS.

// PS : USING VISITED ARRAYS IS MOOT HERE BECAUSE THE PROBLEM STATEMENT HAS SPECIFIED THAT THEY WILL BE GIVING US AN DIRECTED ACYCLIC GRAPH.

class Solution 
{
    // FUNCTION TO ESTABLISH ALL PATHS FROM NODE 0 TO NODE N-1.
    public void findPaths(int[][] graph,int[] visited,int[] arr,int ind,int node,List<List<Integer>> ans)
    {
        if(node == (graph.length-1))
        {
            arr[ind] = node;
            ind += 1;
            
            List<Integer> temp = new ArrayList<Integer>();
            for(int i=0;i<ind;i++)
            {
                temp.add(arr[i]);
            }
            
            ans.add(temp);
        }
        else
        {
            visited[node] = 1;
            
            for(int i=0;i<graph[node].length;i++)
            {
                if(visited[graph[node][i]] == 0)
                {
                    arr[ind] = node;
                    findPaths(graph,visited,arr,ind+1,graph[node][i],ans);
                }
            }
            
            visited[node] = 0;
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int[] visited = new int[graph.length];
        int[] arr = new int[graph.length];
        
        findPaths(graph,visited,arr,0,0,ans);
        
        return ans;
    }
}

// TIME COMPLEXITY : O(V*V) WHERE V IS THE NUMBER OF VERTICES IN THE GIVEN GRAPH.
// SPACE COMPLEXITY : O(V*V)
