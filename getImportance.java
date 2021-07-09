// NODE STRUCTURE
class Node
{
    public int val;
    public Node next;
    
    public Node(int v)
    {
        this.val = v;
        this.next = null;
    }
}

// STACK OPERATIONS

class stack
{
    public Node head = null;
    
    public void push(int v)
    {
        if(this.head == null)
        {
            this.head = new Node(v);
        }
        else
        {
            Node temp = new Node(v);
            temp.next = this.head;
            this.head = temp;
        }
    }
    
    public int pop()
    {
        int id = this.head.val;
        this.head = this.head.next;
        
        return id;
    }
    
    public Boolean isEmpty()
    {
        if(this.head == null)
        {
            return false;
        }
        return true;
    }
}

// MAIN CLASS

class Solution {
    public int getImportance(List<Employee> employees, int id) 
    {
        HashMap<Integer,Employee> employeeDict = new HashMap<Integer,Employee>();
        int importanceValue = 0;
        
        for(int i=0;i<employees.size();i++)
        {
            employeeDict.put(employees.get(i).id,employees.get(i));
        }
        
        stack s = new stack();
        s.push(id);
        
        while(s.isEmpty())
        {
            int currId = s.pop();
            for(int i=0;i<employeeDict.get(currId).subordinates.size();i++)
            {
                s.push(employeeDict.get(currId).subordinates.get(i));
            }
            importanceValue += employeeDict.get(currId).importance;
        }
        
        return importanceValue;
    }
}
