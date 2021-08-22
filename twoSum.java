// THE PROBLEM STATEMENT IS TO RETURN THE INDEX OF A PAIR OF INTEGERS THAT ADDS UP TO THE TARGET SUM.

// MY APPROACH IS TO EITHER USE AN HASHMAP OR A TWO POINTER APPROACH. IF YOU WANT TO EFFICIENT IN TERMS OF SPACE, GO FOR THE TWO POINTER APPROACH ELSE 
// YOU CAN DO IT USING HASHMAP. BOTH HAS THE SAME TIME COMPLEXITY.

// IN HASHMAP APPROACH, WE TRAVERSE THE ARRAY AND CHECK IF THE DIFFERENCE BETWEEN THE TARGET THE CURRENT INTEGER IS PRESENT IN THE HASHMAP.
// IF IT IS RETURN CURRENT INDEX AND THE STORED INDEX IN THE HASHMAP, ELSE STORE THE INDEX ONTO THE HASHMAP WITH THE CURRENT INTEGER AS THE KEY.

class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int[] ans = new int[2];
        
        for(int i=0;i<numbers.length;i++)
        {
            int req = target - numbers[i];
            
            if(hm.get(req) == null)
            {
                hm.put(numbers[i],i);
            }
            else
            {
                ans[0] = hm.get(req)+1;
                ans[1] = i+1;
                
                return ans;
            }
        }
        
        return null;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

// IN THE TWO POINTER APPROACH, WE HAVE TO HAVE TWO REFERENCE VARIABLES LEFT AND RIGHT WHICH IS INITIALISED TO 0 AND LENGTH OF THE NUMBERS ARRAY MINUS ONE
// RESPECTIVELY. NOW WHILE LEFT POINTER IS LESS THAN RIGHT WE CHECK WHETHER THE THE SUM OF INTEGERS AT THE LEFT AND RIGHT POINTER
// IS EQUAL TO THE TARGET, IF IT IS RETURN THE INDICES ELSE CHECK WHETHER THEIRS SUM IS LESS THAN OR GREATER THAN THE TARGET DEPENDING ON THAT
// WE INCREMENT THE LEFT POINTER OR DECREMENT THE RIGHT POINTER.

class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int l = 0,r = numbers.length-1;
        int[] ans = new int[2];
        
        // TRAVERSING USING TWO POINTER APPROACH.
        while(l<r)
        {
            if(numbers[l]+numbers[r] == target)
            {
                ans[0] = l+1;
                ans[1] = r+1;
                return ans;
            }
            else if(numbers[l]+numbers[r] < target)
            {
                l += 1;
            }
            else if(numbers[l]+numbers[r] > target)
            {
                r -= 1;
            }
        }
        
        return null;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
