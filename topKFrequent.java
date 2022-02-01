// PROBLEM DESCRIPTION : https://leetcode.com/problems/top-k-frequent-elements/

// MY APPROACH IS TO FIRSTLY FIND THE NUMBER OF UNIQUE ELEMENTS AND THE NUMBER OF OCCURRENCES OF EACH UNIQUE ELEMENT IN THE GIVEN ARRAY. THEN BUILD A 2D ARRAY IMPLEMENTATION
// OF HEAP DATA STRUCTURE WHERE EACH INDEX CONTAINS THE UNIQUE ELEMENTS VALUE AND THEIR CORRESPONDING NUMBER OF OCCURRENCES IN THE ARRAY.
// THIS HEAP WILL CONTAIN THE UNIQUE ELEMENT WITH THE HIGHEST NUMBER OF OCCURRENCES TO THE LOWEST NUMBER OF OCCURRENCES. FROM THE HEAP, WE COULD
// RETRIEVE THE TOP K ELEMENTS BASED ON FREQUENCY. 

class Solution 
{
    // FUNCTION TO INSERT IT INTO THE HEAP.
    public void heapifyUp(int[][] heap,int ind)
    {
        while(ind > 0)
        {
            int parentInd = (ind-1)/2;
            
            if(heap[parentInd][1] < heap[ind][1])
            {
                int temp = heap[parentInd][1];
                heap[parentInd][1] = heap[ind][1];
                heap[ind][1] = temp;
                
                temp = heap[parentInd][0];
                heap[parentInd][0] = heap[ind][0];
                heap[ind][0] = temp;
                
                ind = parentInd;
            }
            else
            {
                break;
            }
        }
    }
    
    // FUNCTION TO DELETE FROM THE HEAP.
    public int heapifyDown(int[][] heap,int ind)
    {
        int topElement = heap[0][0];
        
        heap[0][0] = heap[ind][0];
        heap[0][1] = heap[ind][1];
        ind -= 1;
        
        int currInd = 0;
        
        while(((currInd*2)+1) <= ind)
        {
            int lInd = -1,rInd = -1;
            
            if(((currInd*2)+1) <= ind)
            {
                lInd = ((currInd*2)+1);
            }
            
            if(((currInd*2)+2) <= ind)
            {
                rInd = ((currInd*2)+2);
            }
            
            if(rInd == -1)
            {
                if(heap[lInd][1] > heap[currInd][1])
                {
                    int temp = heap[lInd][1];
                    heap[lInd][1] = heap[currInd][1];
                    heap[currInd][1] = temp;
                    
                    temp = heap[lInd][0];
                    heap[lInd][0] = heap[currInd][0];
                    heap[currInd][0] = temp;
                    
                    currInd = lInd;
                }
                else
                {
                    break;
                }
            }
            else
            {
                if(heap[lInd][1] > heap[currInd][1] && heap[lInd][1] >= heap[rInd][1])
                {
                    int temp = heap[lInd][1];
                    heap[lInd][1] = heap[currInd][1];
                    heap[currInd][1] = temp;
                    
                    temp = heap[lInd][0];
                    heap[lInd][0] = heap[currInd][0];
                    heap[currInd][0] = temp;
                    
                    currInd = lInd;
                }
                else if(heap[rInd][1] > heap[currInd][1])
                {
                    int temp = heap[rInd][1];
                    heap[rInd][1] = heap[currInd][1];
                    heap[currInd][1] = temp;
                    
                    temp = heap[rInd][0];
                    heap[rInd][0] = heap[currInd][0];
                    heap[currInd][0] = temp;
                    
                    currInd = rInd;
                }
                else
                {
                    break;
                }
            }
        }
        
        return topElement;
    }
    
    public int[] topKFrequent(int[] nums, int k)
    {
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        // FINDING THE NUMBER OF UNIQUE ELEMENTS AND THE NUMBER OF OCCURRENCES.
        for(int i=0;i<nums.length;i++)
        {
            if(hashmap.get(nums[i]) == null)
            {
                hashmap.put(nums[i],1);
                arr.add(nums[i]);
            }
            else
            {
                hashmap.put(nums[i],hashmap.get(nums[i])+1);
            }
        }
        
        int[][] heap = new int[arr.size()][2];
      
        // INSERTING IT INTO THE HEAP.
        for(int i=0;i<arr.size();i++)
        {
            heap[i][0] = arr.get(i);
            heap[i][1] = hashmap.get(arr.get(i));
            
            heapifyUp(heap,i);
        }
        
        int[] ans = new int[k];
        
        // RETRIEVING THE TOP K ELEMENTS BASED ON FREQUENCY.
        for(int i=0;i<k;i++)
        {
            ans[i] = heapifyDown(heap,heap.length-(i+1));
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(MAX(M LOG M,N))
// SPACE COMPLEXITY : O(M) WHERE M IS THE NUMBER OF UNIQUE ELEMENTS IN THE ARRAY.

