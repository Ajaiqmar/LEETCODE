// THE PROBLEM STATEMENT IS TO DO A POST ORDER TRAVERSAL OF AN N-ARY TREE.
// FOLLOW UP QUESTION IS TO DO IT IN AN ITERATIVE FASHION.

// MY APPROACH IS TO USE THE STACK DATA STRUCTURE, FIRSTLY INSERT THE ROOT NODE ONTO THE STACK THEN USE A WHILE LOOP TO LOOP UNTIL THE
// STACK IS EMPTY. AFTER POPPING THE NODE FROM THE STACK CHECK IF IT HAS CHILDREN NODES AND THAT THE NODE HASN'T BEEN VISITED BEFORE.
// IF IT STAISFIES BOTH THEN MARK THE NODE AS VISITED AND INSERT THE CHILDREN NODE ONTO THE STACK IN REVERSE ORDER. ELSE INSERT THE NODE VALUE ONTO THE ARRAY
// AND CONTINUE.

// ANOTHER APPROACH THAT I CAME ACROSS WAS TO SIMPLY DO A PRE-ORDER TRAVERSAL AND THEN REVERSE THE ARRAY. TO ELIMINATE THE USE OF VISITED VARIABLE.
// BUT THE TIME COMPLEXITY REMAINS O(2N) BECAUSE WE WILL TRAVERSING ONCE AND THEN REVERSING THE LIST.

// STRUCTURE OF THE NODE OF THE STACK.
class StackNode
{
    Node root = null;
    int visited = 0;
    
    public StackNode(Node root)
    {
        this.root = root;
    }
}

class Solution 
{
    public List<Integer> postorder(Node root) 
    {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(root == null)
        {
            return ans;
        }
        
        // INITIALISING THE STACK DATA STRUCTURE.
        Stack<StackNode> s = new Stack<StackNode>();
        s.push(new StackNode(root));
        
        // DFS TRAVERSAL USING AN ITERATIVE APPROACH.
        while(!(s.empty()))
        {
            StackNode temp = s.pop();
            if((temp.root.children.size() == 0) || (temp.visited == 1))
            {
                ans.add(temp.root.val);
            }
            else
            {
                temp.visited = 1;
                s.push(temp);
                for(int i=(temp.root.children.size())-1;i>=0;i--)
                {
                    s.push(new StackNode(temp.root.children.get(i)));
                }
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(2N) == O(N) WHERE N IS THE NUMBER OF NODES.
// SPACE COMPLEXITY : O(H) WHERE H IS THE HEIGHT OF THE N-ARY TREE.
