// THE PROBLEM STATEMENT IS TO RE-CREATE THE GIVEN LINKED LIST. THE NODE OF THE GIVEN LINKED LIST CONTAINS AN INTEGER, A NEXT POINTER AND A RANDOM POINTER.
// THE NEXT POINTER WILL POINT TO THE NEXT NODE IN THE GIVEN LINKED LIST AND THE RANDOM POINTER WILL EITHER BE SET AS NULL OR IT WOULD BE POINTING
// TO A RANDOM NODE PRESENT IN THE LIST. PS: THE LINKED LIST MAY ALSO CONTAIN DUPLICATE VALUES.

// MY APPROACH IS TO TRAVERSE THE GIVEN LINKED LIST AND RE-CREATE THE GIVEN LINKED LIST USING THE NODE CLASS. ON THE FIRST TRAVERSAL WE WILL BE INSERTING,
// ONLY THE INTEGER VALUE OF THE NODE CLASS, WE WILL ALSO BE COLLECTING THE ADDRESS OF EACH NODE PRESENT IN THE GIVEN LINKED LIST AND THEIR INDEX AS
// A KEY AND A VALUE PAIR IN AN HASHMAP AND OBJECT OF THE NODES WE HAVE CREATED IN AN ARRAY. NOW ON THE SECOND TRAVERSAL, WE WILL FIND THE INDEX
// OF THE RANDOM NODE, IN THE GIVEN LINKED LIST USING THE HASHMAP AND USING THAT INDEX WE CAN PINPOINT THE NODE FROM WHAT WE HAVE CREATED.

class Solution 
{
    public Node copyRandomList(Node head) 
    {
        Node temp = head;
        Node newHead = null,newTail = null;
        HashMap<Node,Integer> hashmap = new HashMap<Node,Integer>();
        ArrayList<Node> arr = new ArrayList<Node>();
        int index = 0;
        
        // TRAVERSING THE GIVEN LIKED LIST.
        while(temp != null)
        {
            hashmap.put(temp,index);
            
            Node node = new Node(temp.val);
            
            if(newHead == null)
            {
                newHead = node;
                newTail = node;
            }
            else
            {
                newTail.next = node;
                newTail = newTail.next;
            }
            
            arr.add(node);
            
            index += 1;
            temp = temp.next;
        }
        
        temp = head;
        Node t = newHead;
        
        // TRAVERSING TO FIND OUT THE RANDOM POINTER OF EACH NODE IN A LINKED LIST.
        while(temp != null)
        {
            if(temp.random != null)
            {
                int ind = hashmap.get(temp.random);
                t.random = arr.get(ind);
            }
            
            temp = temp.next;
            t = t.next;
        }
        
        return newHead;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
