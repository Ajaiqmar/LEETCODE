// THE PROBLEM STATEMENT IS TO FIND THE NEXT WARMEST DAY FOR EACH INDEX IN THE TEMPERATURES ARRAY, WHERE TEMPERATURES ARRAY REPRESENTS THE DAILY TEMPERATURE
// FOR A PERIOD OF N DAYS. THE NEXT WARMEST DAY IS WHEN THE TEMPERATURE IS HIGHER THAN THE CURRENT INDEX VALUE.

// MY APPROACH IS TO USE THE STACK DATA STRUCTURE, WE CAN TRAVERSE FROM RIGHT TO LEFT AND KEEP THE TEMPERATURES IN CHECKB USING THE STACK DATA STRUCTURE.
// WE TRAVERSE THE ARRAY AND REMOVE THE TOP ELEMENT UNTIL THE TOP ELEMENTS VALUE IS LESSER THAN OR EQAUL TO THE CURRENT INDEX VALUE,
// THEN WE CAN FIND OUT THE DISTANCE USING THE INDEX VALUE. THEN FINALLY WE PUSH THE CURRENT INDEX VALUE.

// STRUCTURE OF THE STACK'S NODE.
class Node
{
    int index;
    int value;
    
    Node(int v,int i)
    {
        this.value = v;
        this.index = i;
    }
}

class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int n = temperatures.length;
        int[] ans = new int[n];
        // DECLARING AND INITIALSING THE STACK DS.
        Stack<Node> stack = new Stack<Node>();
        
        // TRAVERSING THE TEMPERATURES ARRAY FROM RIGHT TO LEFT.
        for(int i=n-1;i>=0;i--)
        {
            while(stack.size() > 0 && stack.peek().value <= temperatures[i])
            {
                stack.pop();
            }
            
            if(stack.size() != 0)
            {
                Node temp = stack.peek();
                ans[i] = (temp.index-i);
            }
            
            stack.push(new Node(temperatures[i],i));
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*L) WHERE L IS THE MAXIMUM ELEMENTS POPPED TO FIND THE CURRENT INDEX VALUE.
// SPACE COMPLEXITY : O(N)
